package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import view.Menu;

public class CandidateManagement extends Menu {

    Scanner sc = new Scanner(System.in);
    ArrayList<Candidate> candidates = new ArrayList<>();

    public CandidateManagement(String td, String[] mc) {
        super(td, mc);
    }

    public static void main(String[] args) {
        String mChon[] = {"Experience", "Fresher", "Internship", "Searching", "Exit"};
        CandidateManagement candidateManagement = new CandidateManagement("CANDIDATE MANAGEMENT SYSTEM", mChon);
        candidateManagement.run();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createCandidate(0);
                break;
            case 2:
                createCandidate(1);
                break;
            case 3:
                createCandidate(2);
                break;
            case 4:
                searchCandidate();
                break;
            case 5:
                System.exit(0);
        }
    }

    public void createCandidate(int type) {
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
            if (Validator.checkIdExist(candidates, id) == false) {
                switch (type) {
                    case 0:
                        createExperience(candidate);
                        break;
                    case 1:
                        createFresher(candidate);
                        break;
                    case 2:
                        createInternship(candidate);
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

    public void createExperience(Candidate candidate) {
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

    public void createFresher(Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validator.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validator.checkInputGraduationRank();
        System.out.print("Enter University: ");
        String university = sc.nextLine();
        candidates.add(new Fresher(candidate.getId(), candidate.getFName(), candidate.getLName(),
                candidate.getDob(), candidate.getAdd(), candidate.getPhone(),
                candidate.getEmail(), candidate.getType(), graduationDate, graduationRank, university));
        System.err.println("Create success.");
    }

    public void createInternship(Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validator.checkInputString();
        System.out.print("Enter semester: ");
        int semester = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter university: ");
        String university = Validator.checkInputString();
        candidates.add(new Intern(candidate.getId(), candidate.getFName(), candidate.getLName(),
                candidate.getDob(), candidate.getAdd(), candidate.getPhone(),
                candidate.getEmail(), candidate.getType(), major, semester, university));
        System.err.println("Create success.");
    }

    public void searchCandidate() {
    printListNameCandidate();
    System.out.print("Enter candidate name (First name or Last name): ");
    String nameSearch = Validator.checkInputString();
    System.out.print("Enter type of candidate: ");
    int typeCandidate = Validator.checkInputIntLimit(0, 2);
    
    System.out.println("The candidates found:");
    for (Candidate candidate : candidates) {
        if (candidate.getType() == typeCandidate
                && (candidate.getFName().contains(nameSearch) || candidate.getLName().contains(nameSearch))) {
            System.out.println(candidate.getFName() + " " + candidate.getLName() +
                    " | " + candidate.getDob() + " | " + candidate.getAdd() +
                    " | " + candidate.getPhone() + " | " + candidate.getEmail() +
                    " | " + candidate.getType());
        }
    }
}


    public void printListNameCandidate() {
        System.out.println("List of candidates:");
        System.out.println("==========EXPERIENCE CANDIDATE===========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFName() + " " + candidate.getLName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFName() + " " + candidate.getLName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Intern) {
                System.out.println(candidate.getFName() + " " + candidate.getLName());
            }
        }
    }

}
