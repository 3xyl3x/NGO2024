package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Project {
    private String id;
    private String title;
    private String description;
    public Project(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    
      public String getId() {
        return id;
    }

    public String title() {
        return title;
    }
    public String description() {
        return description;
    }
    public String toString() {
        return "ID: " + id + ", Namn: " + title + " " + description;
    }
}
