/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author leia
 */

import java.util.ArrayList;

public class Department {
    private int id;
    private String name;
    private String description;
    private String phone;
    private String adress;
    private String mail;
    
      private ArrayList<Employee> employees;
      private ArrayList<Project> projects;
    
    public Department(int id, String name, String description, String phone, String adress, String mail)
            {
            this.id = id;
            this.name = name;
            this.description = description;
            this.phone = phone;
            this.adress = adress;
            this.mail = mail;
            
            this.employees = new ArrayList<>();
            this.projects = new ArrayList<>();
            }
    
    
    public String getName()
    {
    return name;
    }
    
    public String getDescription()
    {
    return description;
    }
    
    public String getPhone()
    {
    return phone;
    }
    
    public String getAdress()
    {
            return adress;
    }
    
    public String getMail()
    {
            return mail;
    }
    
    public void changeName(String name)
    {
          this.name = name;
          System.out.println("The name of the department has been changed to: " + this.name);
    }
    
    public void changeDescription(String description)
    {
          this.description = description;
          System.out.println("New description of the department: " + this.description);
    }
    
    public void changePhone(String phone)
    {
          this.phone = phone;
          System.out.println("The phonenumber of the department has been changed to: " + this.phone);
    }
    
    public void changeAdress(String adress)
    {
          this.adress = adress;
          System.out.println("The departments adress has been changed to: " + this.adress);
    }
    
    public void changeMail(String mail)
    {
          this.mail = mail;
          System.out.println("The mail to the department has been changed to: " + this.mail);
    }
    
    public void listAllEmployees()
    {
    System.out.println("Employees of the department " + name + ": ");
        for (Employee employee : employees) {
            System.out.println(employee.getLastName() + ", " + employee.getFirstName()); 
        }
    }
    
    public void listAllProjects()
    {
    System.out.println("Projects connected to the department " + name + ":");
    for (Project project : projects) {
      //  System.out.println(project.title()); 
    }
    }
}
