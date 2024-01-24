package model;

public class Country implements Comparable<Country> {

    protected String countryCode;
    protected String countryName;
    protected double countryArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, double countryArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryArea = countryArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(double countryArea) {
        this.countryArea = countryArea;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-25s%-20.0f", this.countryCode, this.countryName, this.countryArea);
    }

    @Override
    public int compareTo(Country o) {
        return this.getCountryName().compareToIgnoreCase(o.getCountryName());
    }
}