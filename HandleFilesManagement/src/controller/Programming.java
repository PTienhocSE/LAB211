package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import model.Person;
import view.Menu;

public class Programming extends Menu {

    Scanner sc = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList<>();

    public Programming(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                findPersonInfo();
                break;
            case 2:
                copyNewFile();
                break;
            case 3:
                System.out.println("Exiting program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter again.");
        }
    }

    public void findPersonInfo() {
        System.out.println("--------- Person info ---------");
        System.out.print("Enter path file: ");
        String pathFile = sc.nextLine();
        double money = -1;
        while (money < 0) {
            System.out.print("Enter money: ");
            try {
                money = Double.parseDouble(sc.nextLine());
                if (money < 0) {
                    System.out.println("Money must not be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        personList = getListPerson(pathFile);
        if (personList != null) {
            printListPerson(personList, money);
        }
    }

    public void copyNewFile() {
        System.out.println("------------- Copy text --------------");
        System.out.print("Enter Source: ");
        String sourcePath = sc.nextLine();
        System.out.print("Enter new file name: ");
        String destFileName = sc.nextLine();
        String content = getNewContent(sourcePath);
        String destPath = destFileName; 
        if (writeNewContent(destPath, content)) {
            System.out.println("Copy done...");
        } else {
            System.out.println("Copy failed...");
        }
    }

    public ArrayList<Person> getListPerson(String pathFile) {
        ArrayList<Person> personList = new ArrayList<>();
        File file = new File(pathFile);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist or is not a file.");
            return null;
        }
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] infoPerson = line.split(";");
                double salary = getSalary(infoPerson[2]);
                personList.add(new Person(infoPerson[0], infoPerson[1], salary));
            }
        } catch (IOException e) {
            System.err.println("Can't read file.");
        }
        return personList;
    }

    public double getSalary(String salary) {
        try {
            return Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void printListPerson(ArrayList<Person> personList, double money) {
        if (personList.isEmpty()) {
            System.out.println("No person found.");
            return;
        }
        
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        Person minPerson = personList.get(0);
        Person maxPerson = personList.get(0);

        for (Person person : personList) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(), person.getAddress(), person.getMoney());
                if (person.getMoney() < minPerson.getMoney()) {
                    minPerson = person;
                }
                if (person.getMoney() > maxPerson.getMoney()) {
                    maxPerson = person;
                }
            }
        }
        System.out.println("Max: " + maxPerson.getName());
        System.out.println("Min: " + minPerson.getName());
    }

    public String getNewContent(String pathFileInput) {
        HashSet<String> newContent = new HashSet<>();
        File file = new File(pathFileInput);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can’t read file");
        }
        StringBuilder contentBuilder = new StringBuilder();
        for (String word : newContent) {
            contentBuilder.append(word).append(" ");
        }
        return contentBuilder.toString();
    }

    public boolean writeNewContent(String pathFileOutput, String content) {
        File file = new File(pathFileOutput);
        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferWriter.write(content);
            System.err.println("Write successful");
            return true;
        } catch (IOException ex) {
            System.err.println("Can’t write file");
            return false;
        }
    }
}
    