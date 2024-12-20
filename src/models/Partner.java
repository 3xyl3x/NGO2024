package models;

/**
 *
 * @author petra
 */
public class Partner {

    private int partnerId;
    private String name;
    private String contactPerson;
    private String contactEmail;
    private String phoneNumber;
    private String address;
    private String branch;
    private int city;

    public Partner(int partnerId, String name, String contactPerson, String contactEmail, String phoneNumber, String adress, String branch, int city) {
        this.partnerId = partnerId;
        this.name = name;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.branch = branch;
        this.city = city;
    }

    public int getPartnerId() {
        return partnerId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String newContactPerson) {
        contactPerson = newContactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String newContactEmail) {
        contactEmail = newContactEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setaddress(String newAddress) {
        address = newAddress;
    }

    public String getBranch() {
        return branch;
    }

    public void setbranch(String newBranch) {
        address = newBranch;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int newCity) {
        city = newCity;
    }

    @Override
    public String toString() {
        return "ID: " + partnerId + ", Namn:  " + name + ", Kontaktperson:  " + contactPerson + " telefonnummer: " + phoneNumber + ".";
    }
}
