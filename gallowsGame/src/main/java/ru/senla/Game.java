package ru.senla;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final String[] CITIES = {
        "ВОРОНЕЖ", "МОСКВА", "ВЛАДИМИР", "СОЧИ"
    };

    private static final String[] FRUITS = {
            "ЯБЛОКО", "БАНАН", "ГРУША", "СЛИВА"
    };

    private static final String[] PETS = {
            "СОБАКА", "КОШКА", "ХОМЯК", "ПОПУГАЙ"
    };

    private static final String[] GALLOWS = {
            """
            _____________
                         |
                         |
                         |
                         |
                         |
            """,
            """
            _____________
                  |      |
                         |
                         |
                         |
                         |
            """,
            """
            _____________
                  |      |
                  *      |
                         |
                         |
                         |
            """,
            """
            _____________
                  |      |
                  *      |
                 /|\\     |
                  |      |
                         |
            """,
            """
            _____________
                  |      |
                  *      |
                 /|\\     |
                  |      |
                 /       |
            """,
            """
            _____________
                  |      |
                  *      |
                 /|\\     |
                  |      |
                 / \\     |
            """
    };

    public static void run() {
        System.out.println("Добро пожаловать в игру Виселица");
        System.out.println("Правила просты: вы должны отгадать слово из выбранной темы");
        System.out.println();
        mainMenu();
    }

    private static void mainMenu() {
        System.out.println("Введите цифру, соответствующую следующему действию:");
        System.out.println("1. Начать игру");
        System.out.println("2. Выйти из игры");
        Scanner scanner = new Scanner(System.in);

        try {
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    themeMenu();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Введите цифру, соответствующую пункту меню.");
                    System.out.println("Пример: 1\n");
                    mainMenu();
            }

        } catch (InputMismatchException e) {
            System.out.println("Неправильный ввод. Введите цифру");
            System.out.println("Пример: 1\n");
            mainMenu();
        }
    }

    private static void themeMenu() {
        System.out.println("Выберите тему при помощи ввода соответствующей цифры:");
        System.out.println("1. Города");
        System.out.println("2. Фрукты");
        System.out.println("3. Домашние питомцы");
        System.out.println("4. Вернуться в главное меню");
        Scanner scanner = new Scanner(System.in);
        try {
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    game(randomWordFromArray(CITIES));
                    break;
                case 2:
                    game(randomWordFromArray(FRUITS));
                    break;
                case 3:
                    game(randomWordFromArray(PETS));
                    break;
                case 4:
                    mainMenu();
                    break;
                default:
                    System.out.println("Введите цифру, соответствующую пункту меню.");
                    System.out.println("Пример: 1\n");
                    mainMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Неправильный ввод. Введите цифру");
            System.out.println("Пример: 1\n");
            themeMenu();
        }
    }

    private static String randomWordFromArray(String[] arr) {
        Random random = new Random();
        return arr[random.nextInt(arr.length)];
    }

    private static void game(String word) {
        String hiddenWord = generateHiddenWord(word.length());
        int countOfAttempts = 6;
        Scanner scanner = new Scanner(System.in);

        while (countOfAttempts != 0 && !hiddenWord.equalsIgnoreCase(word)) {
            if (countOfAttempts != 6) {
                System.out.println(GALLOWS[5-countOfAttempts]);
            }
            System.out.println("Загаданное слово: " + hiddenWord);
            System.out.println("Число оставшихся попыток: " + countOfAttempts);
            System.out.print("Введите букву: ");
            char symbol = Character.toUpperCase(scanner.next().charAt(0));
            char[] hiddenWordArray = hiddenWord.toCharArray();

            if (hiddenWord.indexOf(symbol) != - 1) {
                System.out.println("Буква " + symbol + " уже была отображена на табле.");
            } else if (word.indexOf(symbol) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (symbol == word.charAt(i)) {
                        hiddenWordArray[i] = word.charAt(i);
                    }
                }
                hiddenWord = String.valueOf(hiddenWordArray);
            } else {
                countOfAttempts--;
            }
        }

        if (countOfAttempts == 0) {
            System.out.println("Увы! Вы не успели отгадать слово...");
        } else {
            System.out.println("Вы смогли отгадать слово! ");
        }
        System.out.println("Выход в меню...");
        mainMenu();
    }

    private static String generateHiddenWord(int size) {
        char[] arr = new char[size];
        Arrays.fill(arr, '_');
        return new String(arr);
    }
}
