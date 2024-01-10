package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

public class CandidateManagement {

    //allow user input information common of candidate
    public static void createCandidate(ArrayList<Candidate> candidates, int type) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter id: ");
            String id = Validator.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = Validator.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validator.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validator.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validator.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Validator.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Validator.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            if (Validator.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validator.checkInputYN()) {
                return;
            }
        }
    }

    //allow user create experience
    public static void createExperience(ArrayList<Candidate> candidates,
            Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validator.checkInputExprience(candidate.getDob());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validator.checkInputString();
        candidates.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFName(), candidate.getLName(),
                candidate.getDob(), candidate.getAdd(),
                candidate.getPhone(), candidate.getEmail(), candidate.getType()));
        System.err.println("Create success.");
    }

    //allow user create fresher
    public static void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graduation date: ");
        String graduationDate = Validator.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validator.checkInputGraduationRank();
        System.out.print("Enter University: ");
        String university = sc.nextLine();
        candidates.add(new Fresher(candidate.getId(), candidate.getFName(), candidate.getLName(), candidate.getDob(), candidate.getAdd(), candidate.getPhone(), candidate.getEmail(), candidate.getType(), graduationDate, graduationRank, university));
        System.err.println("Create success.");
    }

    //allow user create internship
    public static void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter major: ");
        String major = Validator.checkInputString();
        System.out.print("Enter semester: ");
        int semester = sc.nextInt();
        System.out.print("Enter university: ");
        String university = Validator.checkInputString();
        candidates.add(new Intern(candidate.getId(), candidate.getFName(), candidate.getLName(), candidate.getDob(), candidate.getAdd(), candidate.getPhone(), candidate.getEmail(), candidate.getType(), major, semester, university));
        System.err.println("Create success.");
    }

    //allow user search candidate by name
    public static void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validator.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = Validator.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getType()== typeCandidate && candidate.getFName().contains(nameSearch) || candidate.getLName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

    //display list name candidate
    public static void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFName()+ " "+ candidate.getLName());
            }
        }
        System.err.println("Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFName()+ " "+ candidate.getLName());
            }
        }
        System.err.println("Internship Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Intern) {
                System.out.println(candidate.getFName()+ " "+ candidate.getLName());
            }
        }
    }

}
