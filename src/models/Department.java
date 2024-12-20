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
    private String address;
    private String email;
    
    public Department(int id, String name, String description, String phone, String address, String email)
            {
            this.id = id;
            this.name = name;
            this.description = description;
            this.phone = phone;
            this.address = address;
            this.email = email;
            }
        public int getId()
    {
    return id;
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
    
    public String getAddress()
    {
            return address;
    }
    
    public String getEmail()
    {
            return email;
    }
    
    public void setName(String name)
    {
          this.name = name;
          System.out.println("The name of the department has been changed to: " + this.name);
    }
    
    public void setDescription(String description)
    {
          this.description = description;
          System.out.println("New description of the department: " + this.description);
    }
    
    public void setPhone(String phone)
    {
          this.phone = phone;
          System.out.println("The phonenumber of the department has been changed to: " + this.phone);
    }
    
    public void setAdress(String address)
    {
          this.address = address;
          System.out.println("The departments adress has been changed to: " + this.address);
    }
    
    public void setMail(String email)
    {
          this.email = email;
          System.out.println("The mail to the department has been changed to: " + this.email);
    }
    
        @Override
    public String toString() {
        return "ID: " + id + ", Namn: " + name;
    }
}
    
