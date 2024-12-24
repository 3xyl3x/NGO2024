
package models;


public class Manager extends Employee {
    private String responsibilityArea;
    private int mentorId;

    public Manager(int id, String firstName, String lastName,String address, String email, String phone, String employmentDate,int departmentID,String responsibilityArea,int mentorId) {
        super(id, firstName, lastName, address, email, phone, employmentDate,departmentID);
        this.responsibilityArea = responsibilityArea;
        this.mentorId=mentorId;
    }
    
    public String getResponsibilityArea() {
        return responsibilityArea;
    }
    
    public int getMentorId() {
        return mentorId;
    }
}