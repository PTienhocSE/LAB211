package model;

public class Candidate {

    private int id;
    private String FName, LName;
    private int dob;
    private String add;
    private int phone;
    private String email;
    private int type;

    public Candidate() {
    }

    public Candidate(int id, String FName, String LName, int dob, String add, int phone, String email, int type) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
        this.dob = dob;
        this.add = add;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "candidate{" + "FName=" + FName + ", LName=" + LName + ", dob=" + dob + ", add=" + add + ", phone=" + phone + ", email=" + email + ", type=" + type + '}';
    }

}
