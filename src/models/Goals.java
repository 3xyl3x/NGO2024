/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author leia
 */

public class Goals {
    private int id;
    private String name;
    private int number;
    private String description;
    private int priority;

public Goals(int id, String name, int number, String description, int priority)
{
this.id = id;
this.name = name;
this.number = number;
this.description = description;
this.priority = priority;
}

public void showAllInfo()
{
System.out.println("Name: " + name);
System.out.println("Number: " + number);
System.out.println("Description: " + description);
System.out.println("Priority: " + priority);
}
}
