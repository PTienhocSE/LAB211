package model;

public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, double countryArea) {
        super(countryCode, countryName, countryArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", this.countryCode, this.countryName, this.countryArea, this.countryTerrain);
    }
}
