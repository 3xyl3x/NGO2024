/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author leia
 */

public class City {
    private int id;
    private String name;
    
    public City(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public String getName()
    {
            return name;
    }
    
}
