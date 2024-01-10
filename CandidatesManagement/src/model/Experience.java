/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phuct
 */
public class Experience extends Candidate {

    private int ExpInYear;
    private String ProSkill;

    public Experience(int ExpInYear, String ProSkill) {
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public Experience(int ExpInYear, String ProSkill, int id, String FName, String LName, int dob, String add, int phone, String email, int type) {
        super(id, FName, LName, dob, add, phone, email, type);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }
    

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }

    @Override
    public String toString() {
        return "Fresher{" + "ExpInYear=" + ExpInYear + ", ProSkill=" + ProSkill + '}';
    }

}
