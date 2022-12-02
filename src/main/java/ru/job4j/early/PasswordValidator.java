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
        boolean digit = false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean specialSymbol = false;
        for (char pass: password.toCharArray()) {
            if (digit && lowerCase && upperCase && specialSymbol) {
                break;
            }
            if (Character.isDigit(pass)) {
                digit = true;
            } else if (Character.isLowerCase(pass)) {
                lowerCase = true;
            }else if (Character.isUpperCase(pass)) {
                upperCase = true;
            } else if (!Character.isDigit(pass) && !Character.isLetter(pass)
                    && !Character.isWhitespace(pass)) {
                specialSymbol = true;
            }
        }
        if (!digit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (!lowerCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (!upperCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (!specialSymbol) {
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
