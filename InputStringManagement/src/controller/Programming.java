package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Text; // Import class Text from the model package

public class Programming {
    Validation validation = new Validation();
    Scanner sc = new Scanner(System.in);

    public void run() {
        System.out.println("===== Analysis String program ====");
        System.out.print("Input string: ");
        String inputString = sc.nextLine();

        Text text = new Text(inputString);
        System.out.println("-----Result Analysis------");
        performAnalysis(text);
    }

    public void performAnalysis(Text text) {

        HashMap<String, List<Integer>> numberAnalysis = getNumber(text.getContent());
//        System.out.println("Number Analysis:");
        for (Map.Entry<String, List<Integer>> entry : numberAnalysis.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue().toString());
        }

        HashMap<String, StringBuilder> characterAnalysis = getCharacter(text.getContent());
//        System.out.println("Character Analysis:");
        for (Map.Entry<String, StringBuilder> entry : characterAnalysis.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue().toString());
        }
    }

    public HashMap<String, List<Integer>> getNumber(String inputString) {
        HashMap<String, List<Integer>> numberAnalysis = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> squareNumbers = new ArrayList<>();

        String[] numbers = inputString.split("\\D+");
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                allNumbers.add(num);
                if (num % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }
                if (validation.isPerfectSquare(num)) {
                    squareNumbers.add(num);
                }
            }
        }

        numberAnalysis.put("All Numbers: ", allNumbers);
        numberAnalysis.put("Even Numbers: ", evenNumbers);
        numberAnalysis.put("Odd Numbers: ", oddNumbers);
        numberAnalysis.put("Perfect Square Numbers: ", squareNumbers);

        return numberAnalysis;
    }


    public HashMap<String, StringBuilder> getCharacter(String inputString) {
        HashMap<String, StringBuilder> characterAnalysis = new HashMap<>();
        StringBuilder allCharacters = new StringBuilder();
        StringBuilder upperCaseCharacters = new StringBuilder();
        StringBuilder lowerCaseCharacters = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();

        for (char ch : inputString.toCharArray()) {
            allCharacters.append(ch);
            if (Character.isUpperCase(ch)) {
                upperCaseCharacters.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lowerCaseCharacters.append(ch);
            } else if (!Character.isDigit(ch) && !Character.isWhitespace(ch)) {
                specialCharacters.append(ch);
            }
        }

        characterAnalysis.put("All Characters: ", allCharacters);
        characterAnalysis.put("Uppercase Characters: ", upperCaseCharacters);
        characterAnalysis.put("Lowercase Characters: ", lowerCaseCharacters);
        characterAnalysis.put("Special Characters: ", specialCharacters);

        return characterAnalysis;

    }
}
