package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);
    String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public String checkInputDate() {
        while (true) {
            try {
                String result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);

                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            } catch (ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputTaskTypeId() {
    while (true) {
        try {
            int n = Integer.parseInt(sc.nextLine());
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
                    break;
                default:
                    System.err.println("Invalid task type ID. Please enter a valid task type ID.");
                    continue;
            }
            return result;
        } catch (NumberFormatException ex) {
            System.err.println("Invalid input. Please enter a valid task type ID.");
        }
    }
}


//    public double checkInputPlan() {
//        while (true) {
//            String result = checkInputString();
//            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
//                    && Double.parseDouble(result) <= 17.5) {
//                return result;
//            } else {
//                System.err.println("Re-input.");
//            }
//        }
//    }


public double checkInputPlan() {
    while (true) {
        double result;
        try {
            result = Double.parseDouble(sc.nextLine());
            if (result >= 8.0 && result <= 17.5) {
                return result;
            } else {
                System.out.println("Input must be between 8.0 and 17.5.");
            }
        } catch (NumberFormatException ex) {
            System.err.println("Invalid input. Please enter a valid number.");
        }
    }
}

}