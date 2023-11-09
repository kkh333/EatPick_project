package org.example.member.controller;

import org.example.Container;

public class PasswordValidator {
    public static boolean isPasswordValid(String password) {
        // 비밀번호가 9자 이상인지 확인
        if (password.length() < 9) {
            return false;
        }

        // 대소문자 구분 없이 영어 문자가 최소한 하나 이상 포함되었는지 확인
        boolean hasLetter = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
                break;
            }
        }

        // 특수문자를 포함하는지 확인
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if ("!@#$%^&*()_-+=<>?".contains(String.valueOf(c))) {
                hasSpecialChar = true;
                break;
            }
        }

        // 모든 조건을 만족하는지 확인
        return hasLetter && hasSpecialChar;
    }

    public static String getErrorMessage(String password) {
        if (password.length() < 9) {
            return "비밀번호는 9자 이상이어야 합니다.";
        }

        boolean hasLetter = false;
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
                break;
            }
        }

        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if ("!@#$%^&*()_-+=<>?".contains(String.valueOf(c))) {
                hasSpecialChar = true;
                break;
            }
        }

        // 공백을 포함하지 않는지 확인
        boolean hasWhitespace = false;
        for (char c : password.toCharArray()) {
            if (Character.isWhitespace(c)) {
                hasWhitespace = true;
                break;
            }
        }

        if (!hasLetter) {
            return "비밀번호는 대소문자 구분 없이 영어 문자가 최소한 하나 이상 포함되어야 합니다.";
        }

        if (!hasSpecialChar) {
            return "비밀번호는 특수문자를 최소한 하나 이상 포함해야 합니다.";
        }

        if (hasWhitespace) {
            return "비밀번호는 공백을 포함하면 안 됩니다.";
        }

        return "비밀번호는 9자 이상이어야 하고, 대소문자 구분 없이 영어 문자가 최소한 하나 이상, " +
                "특수문자를 최소한 하나 이상 포함하며, 공백을 포함하면 안 됩니다.";
    }
}