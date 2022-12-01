package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]");
        }
        if (!hasUpperCaseLetter(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (!hasLowerCaseLetter(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (!hasFigure(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (!hasSpecialSymbol(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol");
        }
        if (hasSubstring(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: "
                            + "qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean hasUpperCaseLetter(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCaseLetter(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasFigure(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialSymbol(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (!Character.isDigit(password.charAt(i)) && !Character.isLetter(password.charAt(i))
                && !Character.isWhitespace(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSubstring(String password) {
        String[] substring = {"qwerty", "12345", "password", "admin", "user"};
        for (String s : substring) {
            if (password.toLowerCase().contains(s)) {
                return true;
            }
        }
        return false;
    }

}
