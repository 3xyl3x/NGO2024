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


public class Goal {
    private int id;
    private String name;
    private int number;
    private String description;
    private int priority;
     private static ArrayList<Goal> goalsList = new ArrayList<>();
   

public Goal(int id, String name, int number, String description, int priority)
{
this.id = id;
this.name = name;
this.number = number;
this.description = description;
this.priority = priority;
goalsList.add(this);
}

public void showAllInfo()
{
    System.out.println("List of all goals:");
    System.out.println( ); // blankrad
        for (Goal goal : goalsList) {
System.out.println("Name: " + name);
System.out.println("Description: " + description);
System.out.println("Number: " + number);
System.out.println("Priority: " + priority);
System.out.println( ); // blankrad
}
}

public int getId()
{
    return id;
}
public String getName()
{
    return name;
}
public int getNumber()
{
    return number;
}
public String getDescription()
{
    return description;
}
public int getPriority()
{
    return priority;
}

public void setId(int id)
{
    this.id = id;
}
public void setName(String name)
{
    this.name = name;
}
public void setNumber(int number)
{
    this.number = number;
}
public void setDescription(String description)
{
    this.description = description;
}
public void setPriority(int priority)
{
    this.priority = priority;
}
}
