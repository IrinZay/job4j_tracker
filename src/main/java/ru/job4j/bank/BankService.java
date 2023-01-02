package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса -
 * хранение данных о пользователях и их счетах,
 * добавлени и удаление пользователей и их счетов,
 * перевод средств с одного счёта на другой.
 * @author Irina Zayats
 * @version 1.0
 */

public class BankService {
    /**
     * Поле для хранения ассоциированных между собой
     * пользователей и их счетов. Хранение осуществляется
     * в коллекции HaspMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в поле {@link BankService#users}.
     * @param user - пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод по номеру паспорта удаляет
     * пользователя из поля {@link BankService#users}.
     * @param passport - номер паспорта пользователя
     * @return - возвращает true, если пользователь с указанным
     * номером паспорта существует и был удалён
     */

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;

    }

    /**
     * Добавляет новый счёт пользователю
     * по номеру паспорта пользователя.
     * @param passport - номер паспорта пользователя {@link User}
     * @param account - новый счёт {@link Account}
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит в поле {@link BankService#users}
     * пользователя по его номеру паспорта.
     * @param passport - номер паспорта пользователя
     * @return - возвращает пользователя, если такой существует
     *          или null, если такого пользователя нет
     */

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Находит в поле {@link BankService#users}
     * счет по номеру счёта и номеру паспорта пользователя.
     * @param passport - номер паспорта пользователя
     * @param requisite - номер счёта
     * @return - возвращает счёт, если такой существует,
     *          или null, если такого счёта нет
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return getAccounts(user).stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод для перевода средств с одного счёта на другой.
     * списывает средства с одного счёта и зачисляет их
     * на другой.
     * @param srcPassport - номер паспорта пользователя,
     *                    от кого будет совершен перевод
     * @param srcRequisite - номер счёта, с которого
     *                     будет совершен перевод
     * @param destPassport - номер поспорта пользователя
     *                     кому будут переведены средства
     * @param destRequisite - номер счёта, на который будут
     *                      переведены средства
     * @param amount - сумма перевода
     * @return - возвращает true, если перевод совершено успешною
     *          или false, если этого сделать не удалось
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null
                && dest != null
                && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список счетов пользователя.
     * @param user - пользователь
     * @return - возвращает список счетов пользователя,
     *          если такой пользователь есть в поле
     *          {@link BankService#users}
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
