package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String employmentDate;
    public Employee(int id, String firstName, String lastName,String address, String email, String phone, String employmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email= email;
        this.phone = phone;
        this.employmentDate = employmentDate;
    }
    
      public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
    return address;
}

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }
    public String toString() {
        return "ID: " + id + ", Namn: " + firstName + " " + lastName;
    }
}
