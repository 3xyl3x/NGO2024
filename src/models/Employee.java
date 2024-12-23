package models;


public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String employmentDate;
    private int departmentId;
    public Employee(int id, String firstName, String lastName,String address, String email, String phone, String employmentDate,int departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email= email;
        this.phone = phone;
        this.employmentDate = employmentDate;
        this.departmentId = departmentId;
    }
    
      public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
    return address;
}

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }
    public int getDepartmentId(){
        return departmentId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        public void setPhone(String phone) {
        this.email = phone;
    }
    public String toString() {
        return "ID: " + id +", Avd-id: "+departmentId+", Namn: " + firstName + " " + lastName;
    }
}
