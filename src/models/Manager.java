/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author david
 */
public class Manager extends Employee {
    private String responsibilityArea;
    private Manager mentor;

    public Manager(int id, String firstName, String lastName,String address, String email, String phone, String employmentDate,String responsibilityArea,Manager mentor) {
        super(id, firstName, lastName, address, email, phone, employmentDate);
        this.responsibilityArea = responsibilityArea;
        this.mentor=mentor;
    }
}