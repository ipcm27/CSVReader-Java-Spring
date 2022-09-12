package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input-csv")
public class SummaryLineCsv {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Department")
    private String Department;
    @Column(name = "Employees")
    private String Employees;
    @Column(name = "MinSalary")
    private String MinSalary;
    @Column(name = "AvgSalary")
    private String AvgSalary;
    @Column(name = "MaxSalary")
    private String MaxSalary;
    @Column(name = "TotalSalary")
    private String TotalSalary;

    public SummaryLineCsv(String id, String department, String employees, String minSalary, String avgSalary, String maxSalary, String totalSalary) {
        this.id =id;
        Department = department;
        Employees = employees;
        MinSalary = minSalary;
        AvgSalary = avgSalary;
        MaxSalary = maxSalary;
        TotalSalary = totalSalary;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getEmployees() {
        return Employees;
    }

    public void setEmployees(String employees) {
        Employees = employees;
    }

    public String getMinSalary() {
        return MinSalary;
    }

    public void setMinSalary(String minSalary) {
        MinSalary = minSalary;
    }

    public String getAvgSalary() {
        return AvgSalary;
    }

    public void setAvgSalary(String avgSalary) {
        AvgSalary = avgSalary;
    }

    public String getMaxSalary() {
        return MaxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        MaxSalary = maxSalary;
    }

    public String getTotalSalary() {
        return TotalSalary;
    }

    public void setTotalSalary(String totalSalary) {
        TotalSalary = totalSalary;
    }
}
