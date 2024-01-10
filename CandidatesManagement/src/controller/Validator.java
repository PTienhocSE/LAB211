package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class Validator {

    public static boolean validateDateOfBirth(String birthDate) {
        int currentYear = LocalDate.now().getYear();
        Pattern pattern = Pattern.compile("^\\d{4}$");
        Matcher matcher = pattern.matcher(birthDate);
        return matcher.matches() && (1900 <= Integer.parseInt(birthDate) && Integer.parseInt(birthDate) <= currentYear);
    }

    public static boolean validatePhone(String phone) {
        Pattern pattern = Pattern.compile("^\\d{10,}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validateYearOfExperience(String years) {
        Pattern pattern = Pattern.compile("^\\d{1,3}$");
        Matcher matcher = pattern.matcher(years);
        return matcher.matches() && (0 <= Integer.parseInt(years) && Integer.parseInt(years) <= 100);
    }

    public static boolean validateRankOfGraduation(String rank) {
        return rank.equals("Excellence") || rank.equals("Good") || rank.equals("Fair") || rank.equals("Poor");
    }

}
