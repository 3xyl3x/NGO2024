package database;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class DatabaseManager {
     private InfDB db;
     public DatabaseManager() {
        try {
            db = new InfDB("ngo_2024", "3306", "dbAdmin2024", "dbAdmin2024PW");
            System.out.println("ANSLUTEN TILL DATABAS");
        } catch (InfException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
     
    public ArrayList<HashMap<String, String>> getEmployees() {
        String query = "SELECT * FROM anstalld";
        try {
            return db.fetchRows(query); 
        } catch (InfException e) {
            System.err.println("Problem att hämta anställda: " + e.getMessage());
            return new ArrayList<>(); 
        }
    }
    public ArrayList<HashMap<String, String>> getProjects() {
    String query = "SELECT * FROM projekt";
    try {
        return db.fetchRows(query); 
    } catch (InfException e) {
        System.err.println("Problem att hämta projekt: " + e.getMessage());
        return new ArrayList<>(); 
    }
}
}
