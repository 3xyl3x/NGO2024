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
    
}
