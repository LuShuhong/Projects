package com.thg.accelerator.se.shuhong.assignments.EmployeeManagement;

import java.util.ArrayList;

public class EmployeeManagementSystem {

    private ArrayList<Employee> employees;
    public EmployeeManagementSystem(){
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) throws DuplicateEmployeeIdException{
        for(Employee eachEmployee: employees){
            if(eachEmployee.getEmployeeID()==employee.getEmployeeID()){
                throw new DuplicateEmployeeIdException(employee.getEmployeeID());
            }
        }
        employees.add(employee);
    }

    public Employee getEmployeeById(int id) throws NoSuchEmployeeException{
        for(Employee employee: employees){
            if(id == employee.getEmployeeID()){
                return employee;
            }
        }
        throw new NoSuchEmployeeException(Integer.toString(id));
    }

    public double getTotalSalary() throws NoEmployeeToComputeException{
        if(employees.size()==0){
            throw new NoEmployeeToComputeException();
        }
        double totalSalary = 0;
        for (Employee employee: employees){
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public double getAverageSalaryByRole(String role) throws NoEmployeeToComputeException{
        if(employees.size()==0){
            throw new NoEmployeeToComputeException();
        }
        double roleTotalSalary = 0;
        int roleTotalNumber = 0;
        for (Employee employee: employees){
            if(employee.getJobTitle().equals(role)){
                roleTotalSalary+= employee.getSalary();
                roleTotalNumber ++;
            }
        }
        return roleTotalSalary/roleTotalNumber;
    }


}
