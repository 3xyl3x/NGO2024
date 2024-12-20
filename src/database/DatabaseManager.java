package database;
import oru.inf.*;
import models.*;
import java.util.ArrayList;
import java.util.HashMap;
import util.ErrorHandler;
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
    
    // Metod för att hämta alla anställda
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employeesList = new ArrayList<>();
        String query = "SELECT * FROM anstalld";

        try {
            ArrayList<HashMap<String, String>> results = db.fetchRows(query);

            if (results != null) {
                for (HashMap<String, String> row : results) {
                    employeesList.add(new Employee(
                            Integer.parseInt(row.get("aid")),
                            row.get("fornamn"),
                            row.get("efternamn"),
                            row.get("adress"),
                            row.get("epost"),
                            row.get("telefon"),
                            row.get("anstallningsdatum")
                    ));
                }
            }
        } catch (InfException e) {
            System.err.println("KUNDE INTE HÄMTA ANSTÄLLDA: " + e.getMessage());
        }
        return employeesList;
    }
    
        // Metod för att hämta alla projekt
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projectsList = new ArrayList<>();
        String query = "SELECT * FROM projekt";

        try {
            ArrayList<HashMap<String, String>> results = db.fetchRows(query);

            if (results != null) {
                for (HashMap<String, String> row : results) {
                 //   projectsList.add(new Project(row.get("pid"), row.get("projektnamn"), row.get("beskrivning")));
                }
            }
        } catch (InfException e) {
            System.err.println("KUNDE INTE HÄMTA PROJEKT: " + e.getMessage());
        }
        return projectsList;
    }
    
    public boolean deleteEmployee(int id) {
  
        try {
            db.delete("DELETE FROM anstalld WHERE aid = '"+id+"'");
            return true;
        } catch (InfException e) {
            System.err.println("Fel vid borttagning: " + e.getMessage());
            return false;
        }
 
    }
}
