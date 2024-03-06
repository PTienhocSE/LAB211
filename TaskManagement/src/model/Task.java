/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author phuct
 */
public class Task {
    private int TaskID;
    private String TaskTypeID;
    private String RequirementName;
    private String taskdate;
    private double From, To;
    private String Assignee;
    private String Reviewer;

    public Task() {
    }

    public Task(int TaskID, String TaskTypeID, String RequirementName, String taskdate, double From, double To, String Assignee, String Reviewer) {
        this.TaskID = TaskID;
        this.TaskTypeID = TaskTypeID;
        this.RequirementName = RequirementName;
        this.taskdate = taskdate;
        this.From = From;
        this.To = To;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int TaskID) {
        this.TaskID = TaskID;
    }

    public String getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(String TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public String getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(String taskdate) {
        this.taskdate = taskdate;
    }

    public double getFrom() {
        return From;
    }

    public void setFrom(double From) {
        this.From = From;
    }

    public double getTo() {
        return To;
    }

    public void setTo(double To) {
        this.To = To;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    @Override
    public String toString() {
        return "Task{" + "TaskID=" + TaskID + ", TaskTypeID=" + TaskTypeID + ", RequirementName=" + RequirementName + ", taskdate=" + taskdate + ", From=" + From + ", To=" + To + ", Assignee=" + Assignee + ", Reviewer=" + Reviewer + '}';
    }
    
    
}
