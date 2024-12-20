/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author leia
 */

public class Department {
    private int id;
    private String name;
    private String description;
    private String phone;
    private String adress;
    private String mail;
    
    public Department(int id, String name, String description, String phone, String adress, String mail)
            {
            this.id = id;
            this.name = name;
            this.description = description;
            this.phone = phone;
            this.adress = adress;
            this.mail = mail;
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
    
    public void newName(String name)
    {
          this.name = name;
          System.out.println("The name of the department has been changed to: " + this.name);
    }
    
    public void newDescription(String description)
    {
          this.description = description;
          System.out.println("New description of the department: " + this.description);
    }
    
    public void newPhone(String phone)
    {
          this.phone = phone;
          System.out.println("The phonenumber of the department has been changed to: " + this.phone);
    }
    
    public void newAdress(String adress)
    {
          this.adress = adress;
          System.out.println("The departments adress has been changed to: " + this.adress);
    }
    
    public void newMail(String mail)
    {
          this.mail = mail;
          System.out.println("The mail to the department has been changed to: " + this.mail);
    }
    
    
    public void listAllEmployees()
    {
    System.out.println();
    }
    
    public void listAllProjects()
    {
    System.out.println();
    }
}
