/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author david
 */
public class Admin extends Employee {
    private int level;

    public Admin(int id, String firstName, String lastName,String address, String email, String phone, String employmentDate,int departmentID,int level) {
        super(id, firstName, lastName, address, email, phone, employmentDate,departmentID);
        this.level=level;
    }
}