package database;

import java.time.LocalDate;
import oru.inf.*;
import models.*;
import java.util.ArrayList;
import java.util.HashMap;

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

    // Metod för inlogg
    public Employee login(String inputEmail, String inputPassword) {
        try {
            // Hämta grundläggande information från anstalld
            String query = "SELECT * FROM anstalld WHERE epost = '" + inputEmail + "' AND losenord = '" + inputPassword + "'";
            HashMap<String, String> employeeRow = db.fetchRow(query);

            if (employeeRow.isEmpty()) {
                return null;

            }

            int id = Integer.parseInt(employeeRow.get("aid"));
            String firstName = employeeRow.get("fornamn");
            String lastName = employeeRow.get("efternamn");
            String address = employeeRow.get("adress");
            String email = employeeRow.get("epost");
            String phone = employeeRow.get("telefon");
            String employementDate = employeeRow.get("anstallningsdatum");
            int departmentID = Integer.parseInt(employeeRow.get("avdelning"));
            
            // Kontrollerar om användaren är handläggare
            String managerQuery = "SELECT * FROM handlaggare WHERE aid = " + id;
            HashMap<String, String> managerRow = db.fetchRow(managerQuery);

            if (managerRow.isEmpty() == false) {
                String responsibilityArea = managerRow.get("ansvaromrade");
                return new Manager(id, firstName, lastName, address, email, phone, employementDate,departmentID, responsibilityArea, null);
            }

            // Kontrollerar om användaren är administratör
            String adminQuery = "SELECT * FROM admin WHERE aid = " + id;
            HashMap<String, String> adminRow = db.fetchRow(adminQuery);

            if (adminRow.isEmpty() == false) {
                int behorighetsniva = Integer.parseInt(adminRow.get("behorighetsniva"));
                return new Admin(id, firstName, lastName, address, email, phone, employementDate,departmentID, behorighetsniva);
            }

            // Om ingen specifik roll hittas, returnera null
            return null;

        } catch (InfException e) {
            throw new RuntimeException("Fel vid inloggning: " + e.getMessage());
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
                            row.get("anstallningsdatum"),
                            Integer.parseInt(row.get("avdelning"))
                    ));
                }
            }
        } catch (InfException e) {
            System.err.println("KUNDE INTE HÄMTA ANSTÄLLDA: " + e.getMessage());
        }
        return employeesList;
    }
    
    
    
    // Metod för att radera en anställd
    public boolean deleteEmployee(int id) {
        try {
            db.delete("DELETE FROM anstalld WHERE aid = '" + id + "'");
            return true;
        } catch (InfException e) {
            System.err.println("Fel vid borttagning: " + e.getMessage());
            return false;
        }

    }
    
    // Metod för att hämta en avdelning
    public Department getDepartment(int id) {
            try {
            String query = "SELECT * FROM avdelning WHERE avdid= '" + id + "'";
            HashMap<String, String> row = db.fetchRow(query);

            // Ingen avdelning hittades
            if (row.isEmpty()) {
                return null;
            }

                Department department = new Department(id, row.get("namn"), row.get("beskrivning"),row.get("telefon"), row.get("adress"), row.get("epost"));
                return department;
            }
                            catch (InfException e) {
            throw new RuntimeException("Fel vid hämtning av avdelning: " + e.getMessage());
        }
    }
    
        // Metod för att hämta en avdelning
    public ArrayList<Department> getDepartments() {
            try {
                    ArrayList<Department> departments = new ArrayList<>();
            String query = "SELECT * FROM avdelning";
                ArrayList<HashMap<String, String>> results = db.fetchRows(query);
          if (results != null) {
                for (HashMap<String, String> row : results) {
                   departments.add(new Department(
                           Integer.parseInt(row.get("avdid")),
                           row.get("namn"),
                           row.get("beskrivning"),
                           row.get("telefon"),
                            row.get("adress"),
                            row.get("epost")
                            ));
                }
            }
              return departments;
            }
                            catch (InfException e) {
            throw new RuntimeException("Fel vid inloggning: " + e.getMessage());
        }
    }
    
    // Metod för att hämta alla projekt
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projectsList = new ArrayList<>();
        String query = "SELECT * FROM projekt";

        try {
            ArrayList<HashMap<String, String>> results = db.fetchRows(query);

            if (results != null) {
                for (HashMap<String, String> row : results) {
                          projectsList.add(new Project(
                    Integer.parseInt(row.get("pid")), 
                    row.get("projektnamn"), 
                    row.get("beskrivning"),
                    LocalDate.parse(row.get("startdatum")),
                    LocalDate.parse(row.get("slutdatum")),  
                    Double.parseDouble(row.get("kostnad")),
                    row.get("status"),
                    row.get("prioritet"),
                    Integer.parseInt(row.get("projektchef")), 
                    Integer.parseInt(row.get("land"))
                ));
                }
            }
        } catch (InfException e) {
            System.err.println("KUNDE INTE HÄMTA PROJEKT: " + e.getMessage());
        }
        return projectsList;
    }
    
    
    //Metod för att lägga in partnerns id i ett specifikt projekt 
    public boolean addPartnerToProject(Partner partner, Project project) {

        try {
            db.insert("INSERT INTO projekt_partner values (" + project.getId() + ", " + partner.getId() + ")");
            return true;
        } catch (InfException e) {
            System.err.println("Partnern kunde inte kopplas till projektet: " + e.getMessage());
            return false;
        }
    }

    // Metod för att ta bort partner från ett specifikt projekt
    public boolean DeletePartnerFromProject(Partner partner, Project project) {
        try {
            db.delete("DELETE FEOM projekt_partner where partner_pid = " + partner.getId() + " and pid = " + project.getId());
            return true;
        } catch (InfException e) {
            System.err.println("Fel vid borttagning: " + e.getMessage());
            return false;
        }
    }

           
            
            
        
 


}
