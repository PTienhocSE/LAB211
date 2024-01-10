package model;

public class Fresher extends Candidate {

    private int Graduation_date;
    private String Graduation_rank;
    private String Education;

    public Fresher() {
    }

    public Fresher(int Graduation_date, String Graduation_rank, String Education) {
        this.Graduation_date = Graduation_date;
        this.Graduation_rank = Graduation_rank;
        this.Education = Education;
    }

    

    public int getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(int Graduation_date) {
        this.Graduation_date = Graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String Graduation_rank) {
        this.Graduation_rank = Graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }

    @Override
    public String toString() {
        return "Intern{" + "Graduation_date=" + Graduation_date + ", Graduation_rank=" + Graduation_rank + ", Education=" + Education + '}';
    }

}
