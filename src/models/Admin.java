
package models;


public class Admin extends Employee {
    private int level;

    public Admin(int id, String firstName, String lastName,String address, String email, String phone, String employmentDate,int departmentID,int level) {
        super(id, firstName, lastName, address, email, phone, employmentDate,departmentID);
        this.level=level;
    }
    
       public int getLevel() {
           return level;
       }
}