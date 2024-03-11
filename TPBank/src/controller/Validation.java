package controller;

import java.util.Locale;
import java.util.Scanner;

public class Validation {

    public final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    private Scanner sc = new Scanner(System.in);

    public int checkInputIntLimit(int min, int max, Locale language) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please re-enter.");
            }
        }
    }

    public String checkInputString(Locale language) {
        while (true) {
            String result = sc.nextLine();
            if (result.length() == 0) {
                System.out.println("String must not be empty. Re-enter.");
            } else {
                return result;
            }
        }
    }

    public int checkInputAccount(Locale language) {
        while (true) {
            String result = sc.nextLine();
            if (result.matches(ACCOUNT_NUMBER_VALID)) {
                return Integer.parseInt(result);
            }
            System.out.println("Account number must be a number and must have 10 digits. Re-enter.");
        }
    }

    public String checkInputPassword(Locale language) {
        String result;
        while (true) {
            result = checkInputString(language);
            if (isValidPassword(result, language)) {
                return result;
            }
        }
    }

    public boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            System.out.println("Password must be between 8 and 31 characters. Re-enter.");
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {
                System.out.println("Password must contain at least one letter and one digit. Re-enter.");
                return false;
            }
        }
        return true;
    }

    public boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        System.out.println("Enter captcha: ");
        String captchaInput = checkInputString(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
