package com.thg.accelerator.se.shuhong.assignments.EmployeeManagement;

import java.util.ArrayList;

public class EmployeeManagementSystem {

    private ArrayList<Employee> employees;
    public EmployeeManagementSystem(){
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public Employee getEmployeeById(int id){
        for(Employee employee: employees){
            if(id == employee.getEmployeeID()){
                return employee;
            }
        }
        return null;//exception should be used
    }

    public double getTotalSalary(){
        double totalSalary = 0;
        for (Employee employee: employees){
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public double getAverageSalaryByRole(String role){
        double roleTotalSalary = 0;
        int roleTotalNumber = 0;
        for (Employee employee: employees){
            if(employee.getJobTitle().equals(role)){
                roleTotalSalary+= employee.getSalary();
                roleTotalNumber ++;
            }
        }
        return roleTotalSalary ==0? 0: roleTotalSalary/roleTotalNumber;
    }


}
