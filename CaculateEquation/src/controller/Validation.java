package controller;

import java.util.Scanner;
import model.Number;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkEvenandOdd(double n) {
        return n % 2 == 0;
    }

    public static boolean checkSquareNumber(double n) {
        return (int) Math.sqrt(n) * (int) Math.sqrt(n) == n;
    }

    public static void checkProperties(Number... numbers) {
        System.out.print("Number is odd: ");
        for (Number num : numbers) {
            if (!checkEvenandOdd(num.getValue())) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        System.out.print("Number is even: ");
        for (Number num : numbers) {
            if (checkEvenandOdd(num.getValue())) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        System.out.print("Number is perfect square: ");
        for (Number num : numbers) {
            if (checkSquareNumber(num.getValue())) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
