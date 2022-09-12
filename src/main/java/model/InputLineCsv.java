package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input-csv")
public class InputLineCsv {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String Name;
    @Column(name = "dob")
    private String Dob;
    @Column(name = "department")
    private String Department;
    @Column(name = "salary")
    private String Salary;

    public InputLineCsv(String id, String name, String dob, String department, String salary) {
        this.id =id;
        Name = name;
        Dob = dob;
        Department = department;
        Salary = salary;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }


}
