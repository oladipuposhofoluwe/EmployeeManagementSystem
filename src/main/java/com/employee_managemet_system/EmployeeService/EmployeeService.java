package com.employee_managemet_system.EmployeeService;

import com.employee_managemet_system.EmployeeRepository.EmployeeRepository;
import com.employee_managemet_system.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

 List<Employee> getAllEmployees();
 void saveEmployee(Employee employee);
 Employee getEmployeeById(long id);
 void deleteEmployeeById(long Id);
}
