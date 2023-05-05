package com.openclassroom.webapp.service;

import com.openclassroom.webapp.model.Employee;
import com.openclassroom.webapp.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;

    public Employee getEmployee(final int id) {
        return employeeProxy.getEmployee(id);
    }

    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public void deleteEmployee(final int id) {
        employeeProxy.deleteEmployee(id);
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployees;

        employee.setLastName(employee.getLastName().toUpperCase());

        if(employee.getId() == null) {
            savedEmployees = employeeProxy.createEmployee(employee);
        } else {
            savedEmployees = employeeProxy.updateEmployee(employee);
        }
        return savedEmployees;
    }
}
