package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель счёта
 * пользователя банка.
 *  @author Irina Zayats
 *  @version 1.0
 */

public class Account {
    /**
     * Поле номер счёта.
     */
    private String requisite;
    /**
     * Поле баланса средств на счету.
     */
    private double balance;

    /**
     * Конструктор для создания нового счёта.
     * @param requisite - номер счёта
     * @param balance - балланс средств на счету
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод для получения номера счёта {@link Account#requisite}.
     * @return - номер счёта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для присваивания номера счёта {@link Account#requisite}.
     * @param requisite - номер счёта
     */

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод для получения балланса на счету {@link Account#balance}.
     * @return - балланс на счету
     */

    public double getBalance() {
        return balance;
    }
    /**
     * Метод для присваивания балланса счету {@link Account#balance}.
     * @param balance - балланс средств на счету
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Переопределенный метод для сравнения
     * пользователей. сравнение происходит по
     * по полю {@link Account#requisite}.
     * @param o - принимает объект, в данном случае
     *          модель счёта пользователя
     * @return - возвращает true, если номера счетов
     *          идентичны
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hasCode.
     * @return - возвращает hashCode для
     *          поля номер счёта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
