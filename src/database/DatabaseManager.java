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
                int mentorId = Integer.parseInt(managerRow.get("mentor"));
                return new Manager(id, firstName, lastName, address, email, phone, employementDate,departmentID, responsibilityArea, mentorId);
            }

            // Kontrollerar om användaren är administratör
            String adminQuery = "SELECT * FROM admin WHERE aid = " + id;
            HashMap<String, String> adminRow = db.fetchRow(adminQuery);

            if (adminRow.isEmpty() == false) {
                int level = Integer.parseInt(adminRow.get("behorighetsniva"));
                return new Admin(id, firstName, lastName, address, email, phone, employementDate,departmentID, level);
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
    
    // Metod för att uppdatera en anställd
public boolean updateEmployee(Employee employee) {
    try {
        // Uppdatera gemensamma attribut i anstalld
        String query = "UPDATE anstalld SET " +
                       "fornamn = '" + employee.getFirstName() + "', " +
                       "efternamn = '" + employee.getLastName() + "', " +
                        "adress ='" + employee.getAddress() + "', " +
                        "telefon ='" + employee.getPhone() + "', " +
                        "avdelning ='" + employee.getDepartmentId() + "', " +
                       "epost = '" + employee.getEmail() + "' " +
                       "WHERE aid = " + employee.getId();
        db.update(query);

        // Kontrollera om det är en Admin eller Manager och uppdatera specifika attribut i respektive tabell
        if (employee instanceof Admin) {
            Admin admin = (Admin) employee;
            String adminQuery = "UPDATE admin SET " +
                                "behorighetsniva = '" + admin.getLevel() + "' " +
                                "WHERE aid = " + employee.getId();
            db.update(adminQuery);
        } else if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
            String managerQuery = "UPDATE handlaggare SET " +
                                        "ansvarighetsomrade = '" + manager.getResponsibilityArea() + "' " +
                                  "mentor = '" + manager.getMentorId() + "' " +
                                  "WHERE aid = " + employee.getId();
            db.update(managerQuery);
        }

        return true; 
    } catch (InfException e) {
        System.err.println("Kunde inte uppdatera anställd: " + e.getMessage());
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
    public boolean deletePartnerFromProject(Partner partner, Project project) {
        try {
            db.delete("DELETE FEOM projekt_partner where partner_pid = " + partner.getId() + " and pid = " + project.getId());
            return true;
        } catch (InfException e) {
            System.err.println("Fel vid borttagning: " + e.getMessage());
            return false;
        }
    }

    //Metod för att lägga till anställd i specifikt projekt
    public boolean addEmployeeToProject(Employee employee, Project project) {
        try {
            db.insert("INSERT INTO ans_proj values (" + project.getId() + ", " + employee.getId() + ")");
            return true;
        } catch (InfException e) {
            System.err.println("Den anställde kunde inte kopplas till projektet : " + e.getMessage());
            return false;
        }
    }

    //Metod för att ta bort en anställd fråm ett specifikt projekt
    public boolean deleteEmployeeFromProject(Employee employee, Project project) {
        try {
            db.delete("DELETE FROM ans_proj where aid = " + employee.getId() + " and pid = " + project.getId());
            return true;
        } catch (InfException e) {
            System.err.println("Fel vid borttagning: " + e.getMessage());
            return false;
        }
    }

    //Metod för att lägga till hållbarhetsmål i projektet
    public boolean addGoalToProject(Goals goals, Project project) {
        try {
            db.insert("INSERT INTO proj_hallbarhet values (" + project.getId() + ", " + goals.getId() + ")");
            return true;
        } catch (InfException e) {
            System.err.println("Målet kunde inte kopplas till projektet : " + e.getMessage());
            return false;
        }
    }

    //Metod för att ta bort mål från projekt
    public boolean deleteGoalFromProject(Goals goals, Project project) {
        try {
            db.delete("DELETE FROM proj_hallbarhet where hid = " + goals.getId() + " and pid = " + project.getId());
            return true;
        } catch (InfException e) {
            System.err.println("Fel vid borttagning. " + e.getMessage());
            return false;
        }
    }

    //Metod för att lägga till hållbarhetsmål i avdelning
    public boolean addGoalToDepartment(Goals goals, Department department) {
        try {
            db.insert("INSERT INTO avd_hallbarhet values (" + department.getId() + ", " + goals.getId() + ")");
            return true;

        } catch (InfException e) {
            System.err.println("Hållbarthetsmålet kunde inte kopplas till avdelningen : " + e.getMessage());
            return false;
        }

    }

    //Metod för att ta bort mål från avdelning
    public boolean deleteGoalFromDepartment(Goals goals, Department department) {
        try {
            db.delete("DELETE FROM avd_hallbarhet where avdid = " + department.getId() + " and hid = " + goals.getId());
            return true;
        } catch (InfException e) {
            System.err.println("Hållbarhetsmålet kunde inte tas bort från avdelningen : " + e.getMessage());
            return false;
        }
    }

    // Metod för att ta bort en anställd
    public boolean deleteEmployee(Employee employee) {
        try {
            db.delete("DELETE FROM anstalld where aid = " + employee.getId());
            db.delete("DELETE FROM ans_proj where aid = " + employee.getId());
            db.delete("DELETE FROM handlaggare where aid = " + employee.getId());
            db.delete("DELETE FROM admin where aid= " + employee.getId());
            return true;
        } catch (InfException e) {
            System.err.println("Det gick inte att ta bort den anställda : " + e.getMessage());
            return false;
        }
    }
    
    // Metod för att ta bort ett projekt
    public boolean deleteProject(Project project) {
        try {
            db.delete("DELETE FROM projekt where pid = " + project.getId());
            db.delete("DELETE FROM ans_proj where pid = " + project.getId());
            db.delete("DELETE FROM proj_hallbarhet where pid = " + project.getId());
            db.delete("DELETE FROM projekt_partner where pid = " + project.getId());
            return true;
        } catch (InfException e) {
            System.err.println("Det gick inte att ta bort projektet : " + e.getMessage());
            return false;
        }
    }
    
    //Metod för att ta bort en partner
    public boolean deletePartner(Partner partner) {
        try {
            db.delete("DELETE FROM partner where pid = " + partner.getId());
            db.delete("DELETE FROM projekt_partner where pid = " + partner.getId());
            return true;

        } catch (InfException e) {
            System.err.println("Det gick inte att ta bort partnern : " + e.getMessage());
            return false;
        }
    }
    
    //Metod för att skapa och lägga till en ny partner
    public Partner createPartner(String name, String contactPerson, String contactEmail, String phoneNumber, String adress, String branch, int city) {
        try {
            db.insert("INSERT INTO partner values (" + name + ", " + contactPerson + ", " + contactEmail + ", " + phoneNumber + ", " + adress + ", " + branch + ", " + city + ")");
            HashMap<String, String> row = db.fetchRow("SELECT * FROM partner where namn = " + name + " and telefon = " + phoneNumber);
            if (row != null) {
                int pid = Integer.parseInt(row.get("pid"));
                Partner partnern = new Partner(pid, name, contactPerson, contactEmail, phoneNumber, adress, branch, city);
                return partnern;
            } else {
                return null;
            }
        } catch (InfException e) {
            System.err.println("Det gick inte att lägga till en ny partner : " + e.getMessage());
            return null;
        }

    }

}
    
    //metod för att hämta alla hållbarhetsmål
               
    public ArrayList<Goal> getAllGoals() {
              ArrayList<Goal> goalsList = new ArrayList<>();
                    return goalsList;
                }
    
    
    // Metod för att hämta alla hållbarhetsmål för en avdelning (ej join)
    /*
    public ArrayList<Goal> getGoalsForDepartment(int departmentId) {
 ArrayList<Goal> goalsList = new ArrayList<>();
 
 for (int[] mapping : goalDepartmentMapping) {
        if (mapping[1] == departmentId) {
            for (Goal goal : goals) {
                if (goal.getId() == mapping[0]) {
                    goalsList.add(goal);      
                    
            return goalsList;
        }

}
*/
