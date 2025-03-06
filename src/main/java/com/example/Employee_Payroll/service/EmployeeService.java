package com.example.Employee_Payroll.service;

import com.example.Employee_Payroll.dto.EmployeeDTO;
import com.example.Employee_Payroll.model.Employee;
import com.example.Employee_Payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee=new Employee(employeeDTO);
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}