package models;

/**
 *
 * @author petra
 */
public class Country {

    private int countryId;
    private String name;
    private String language;
    private double currency;
    private String timeZone;
    private String politicalStructure;
    private String economy;

    public Country(int countryId, String name, String language, double currency, String timeZone, String politicalStructure, String economy) {
        this.countryId = countryId;
        this.name = name;
        this.language = language;
        this.currency = currency;
        this.timeZone = timeZone;
        this.politicalStructure = politicalStructure;
        this.economy = economy;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String newLanguage) {
        language = newLanguage;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double newCurrency) {
        currency = newCurrency;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String newTimeZone) {
        timeZone = newTimeZone;
    }

    public String getPoliticalStructure() {
        return politicalStructure;
    }

    public void setPoliticalStructure(String newPoliticalStructure) {
        politicalStructure = newPoliticalStructure;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String newEconomy) {
        economy = newEconomy;
    }

    @Override
    public String toString() {
        return "ID: " + countryId + ", Namn: " + name + ", Språk: " + language + ", Politisk struktur: " + politicalStructure + ".";
    }
}
