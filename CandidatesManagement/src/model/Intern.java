package model;

public class Intern extends Candidate {

    private String major;
    private int semester;
    private String universityname;

    public Intern() {
    }

    public Intern(String major, int semester, String universityname) {
        this.major = major;
        this.semester = semester;
        this.universityname = universityname;
    }

    public Intern(String major, int semester, String universityname, int id, String FName, String LName, int dob, String add, int phone, String email, int type) {
        super(id, FName, LName, dob, add, phone, email, type);
        this.major = major;
        this.semester = semester;
        this.universityname = universityname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    @Override
    public String toString() {
        return "Intern{" + "major=" + major + ", semester=" + semester + ", universityname=" + universityname + '}';
    }

}
