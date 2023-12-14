package EmployeeManagementSystem;

public class Employee {
    private int employeeID;
    private String name;
    private String jobTitle;
    private double salary;

    public Employee(int employeeID, String name, String jobTitle, double salary){
        this.employeeID = employeeID;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getName() {
        return name;
    }
}
