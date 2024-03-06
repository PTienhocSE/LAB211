package controller;

import java.util.ArrayList;
import model.Task;
import view.Menu;

public class Programming extends Menu {

    private ArrayList<Task> listTask = new ArrayList<>();
    private Validation valid = new Validation();

    public Programming(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        int id = 1;
        switch (n) {
            case 1:
                addTask(id);
                id++;
                break;
            case 2:
                deleteTask();
                break;
            case 3:
                print();
                break;
            case 4:
                System.exit(0);
        }
    }

    public void addTask(int id) {
        System.out.println("------------Add Task---------------");
        int taskId = listTask.isEmpty() ? 1 : listTask.get(listTask.size() - 1).getTaskID() + 1;
        System.out.print("Enter Requirement Name: ");
        String requirementName = valid.checkInputString();
        System.out.print("Enter Task Type: ");
        String taskTypeId = valid.checkInputTaskTypeId();
        System.out.print("Enter Date: ");
        String date = valid.checkInputDate();
        System.out.print("Enter From: ");
        double planFrom = valid.checkInputPlan();
        System.out.print("Enter To: ");
        double planTo = valid.checkInputPlan();
        System.out.print("Enter Assignee: ");
        String assign = valid.checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = valid.checkInputString();

        listTask.add(new Task(taskId, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
        System.out.println("Add Task Success.");
    }

    public void deleteTask() {
        System.out.println("---------Del Task------");
        if (listTask.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        int findId = findTaskExist();
        if (findId != -1) {
            listTask.remove(findId);
            System.err.println("Delete success.");
        }
    }

    public int findTaskExist() {
        System.out.print("Enter id: ");
        int id = valid.checkInputInt();
        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getTaskID() == id) {
                return i;
            }
        }
        System.out.println("Not found.");
        return -1;
    }

    public void print() {
        if (listTask.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.println("-------------------------------------------- Task ------------------------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < listTask.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    listTask.get(i).getTaskID(),
                    listTask.get(i).getRequirementName(),
                    listTask.get(i).getTaskTypeID(),
                    listTask.get(i).getTaskdate(),
                    listTask.get(i).getTo() - listTask.get(i).getFrom(),
                    listTask.get(i).getAssignee(),
                    listTask.get(i).getReviewer()
            );

        }
    }
}
