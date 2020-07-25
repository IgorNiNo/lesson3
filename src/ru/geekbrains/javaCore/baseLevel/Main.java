package ru.geekbrains.javaCore.baseLevel;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        String[] words = new String[] {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                                       "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                                       "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int userAnswer;
        String wordFromArr = "";
        String userWord = "";

        System.out.println("Приветствуем Вас в игре УГАДАЙ ЧИСЛО");
        do {
            guessNumber();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            userAnswer = scan.nextInt();
        } while (userAnswer != 0);

        System.out.println("Попробуйте отгадать слово, которое загадал компьютер.");
        wordFromArr = words[random.nextInt(words.length)];
        while (! userWord.equals(wordFromArr)){
            System.out.print("Введите слово: ");
            userWord = scan.next();
            guessWord(wordFromArr, userWord);
        }
        System.out.println("\nПоздравляю! Вы угадали.\nБыло загадано слово: " + wordFromArr);
    }

    public static void guessNumber() {
        int number = random.nextInt(10);
        int userNumber;
        int countAttempt = 3;

        System.out.println("Угадайте число от 0 до 9. У вас три попытки.");
        do {
            userNumber = scan.nextInt();
            countAttempt--;

            if(userNumber == number) {
                System.out.println("Поздравляю! Вы угадали. Загаданное число = " + number);
                break;
            }
            if(countAttempt != 0) {
                if(userNumber < number) {
                    System.out.println("Не угадали. Загаданное число больше");
                } else {
                    System.out.println("Не угадали. Загаданное число меньше");
                }
                System.out.println("Осталось " + countAttempt + " попытки");
            } else {
                System.out.println("Вы проиграли. Не растраивайтесь, повезёт в другой раз");
                System.out.println("Было загадано число " + number);
            }
        } while (countAttempt != 0);
    }

    public static void guessWord(String word, String userWrd) {
        int i = 0;

        if(! userWrd.equals(word)) {
            for (i = i; i < Math.min( word.length(), userWrd.length() ); i++) {
                if(userWrd.charAt(i) == word.charAt(i)) {
                    System.out.print(word.charAt(i));
                } else {
                    System.out.print("#");
                }
            }
            for (i = i; i < 15; i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

}
