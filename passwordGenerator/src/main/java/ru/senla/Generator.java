package ru.senla;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    private static final String LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+=-?<>";
    private static final String ALL_CHARS = LOWER_CHARS + UPPER_CHARS + DIGITS + SPECIAL_CHARS;
    private int passwordLength;
    private boolean lowerCharsFlag = false;
    private boolean upperCharsFlag = false;
    private boolean digitsFlag = false;
    private boolean specialCharsFlag = false;

    public Generator() {

    }
    public void run() {
        inputPasswordLength();
        generatePassword();
        System.out.println("Сгенерированный пароль: " + generatePassword());
    }

    private void inputPasswordLength() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину пароля (от 8 до 12): ");
        try {
            passwordLength = scanner.nextInt();

            if (passwordLength < 8 || passwordLength > 12) {
                throw new WrongPasswordLengthException();
            }

        } catch (InputMismatchException e) {
            System.out.println("Неверное значение. Введите целое число. Пример '8'");
            inputPasswordLength();
        } catch (WrongPasswordLengthException e) {
            System.out.println("Неверная длина пароля.");
            inputPasswordLength();
        }
    }

    private String generatePassword() {
        String generatedPassword = "";
        Random random = new Random();

        for (int i = 0; i < passwordLength; i++) {
            generatedPassword += ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length()));
            isConstantsContainsChar(generatedPassword.charAt(i));
        }

        if (!isAllFlags()) {
            setAllFlagsFalse();
            generatePassword();
        }

        return generatedPassword;
    }

    private void isConstantsContainsChar(char c) {
        if (LOWER_CHARS.contains(String.valueOf(c))) {
            lowerCharsFlag = true;
        } else if (UPPER_CHARS.contains(String.valueOf(c))) {
            upperCharsFlag = true;
        } else if (DIGITS.contains(String.valueOf(c))) {
            digitsFlag = true;
        } else if (SPECIAL_CHARS.contains(String.valueOf(c))) {
            specialCharsFlag = true;
        }
    }
    private boolean isAllFlags() {
        return lowerCharsFlag && upperCharsFlag && digitsFlag && specialCharsFlag;
    }

    private void setAllFlagsFalse() {
        lowerCharsFlag = false;
        upperCharsFlag = false;
        digitsFlag = false;
        specialCharsFlag = false;
    }
}
