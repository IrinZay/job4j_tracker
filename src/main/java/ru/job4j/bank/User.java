package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка.
 * @author Irina Zayats
 * @version 1.0
 */
public class User {
    /**
     * Поле номер паспорта.
     */
    private String passport;
    /**
     * Поле Имя пользователя.
     */
    private String username;

    /**
     * Конструктор - создание нового пользователя.
     * @param passport - номер паспорта
     * @param username - имя пользователя
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод получения значения поля {@link User#passport}.
     * @return - возвращает номер паспорта
     */

    public String getPassport() {
        return passport;
    }

    /**
     * Метод записи номера паспорта {@link User#passport}.
     * @param passport - номер паспорта
     */

    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод получения значения поля {@link User#username}.
     * @return - имя пользователя
     */

    public String getUsername() {
        return username;
    }

    /**
     * Метод записи имени пользователя {@link User#username}.
     * @param username - имя пользователя
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод для сравнения
     * пользователей. сравнение происходит по
     * по полю {@link User#passport}.
     * @param o - принимает объект, в данном случае
     *          модель пользователя
     * @return - возвращает true, если номера паспортов
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hasCode.
     * @return - возвращает hashCode для
     *          поля номер паспорта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

}
