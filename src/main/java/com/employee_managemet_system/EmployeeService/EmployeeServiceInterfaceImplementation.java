package com.employee_managemet_system.EmployeeService;

import com.employee_managemet_system.EmployeeRepository.EmployeeRepository;
import com.employee_managemet_system.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceInterfaceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {

        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("employee not found for id " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long Id) {
       this.employeeRepository.deleteById(Id);
    }


}
