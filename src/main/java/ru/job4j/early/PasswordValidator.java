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
        int digit = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int specialSymbol = 0;
        for (char pass: password.toCharArray()) {
            if (Character.isDigit(pass)) {
                digit ++;
            }
            if (Character.isLowerCase(pass)) {
                lowerCase++;
            }
            if (Character.isUpperCase(pass)) {
                upperCase++;
            }
            if (!Character.isDigit(pass) && !Character.isLetter(pass)
                    && !Character.isWhitespace(pass)) {
                specialSymbol++;
            }
        }
        if (digit == 0) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (lowerCase == 0) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (upperCase == 0) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (specialSymbol == 0) {
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
