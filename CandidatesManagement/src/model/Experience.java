
package model;


public class Experience extends Candidate {

    private int ExpInYear;
    private String ProSkill;

    public Experience(int ExpInYear, String ProSkill) {
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public Experience(int ExpInYear, String ProSkill, String id, String FName, String LName, int dob, String add, String phone, String email, int type) {
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
