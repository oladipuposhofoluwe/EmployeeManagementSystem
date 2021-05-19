package com.employee_managemet_system.EmployeeController;


import com.employee_managemet_system.EmployeeService.EmployeeService;
import com.employee_managemet_system.Model.Employee;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.bind.annotation.W3CDomHandler;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


//    display a list of employees by creating a method handler to display the
//    homepage (index.html) to display the list of the employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("EmployeeList", employeeService.getAllEmployees());
        return "index";
    }


//    add an employee
    @GetMapping("/showEmployeeForm")
    public String saveEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newEmployee_form";
    }


//    Save Employee to the database
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
//        save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }


//    update/Edit an employee details
    @GetMapping("/showEmployeeUpdateEditForm/{id}")
    public  String showEmployeeUpdateEditForm(@PathVariable(value = "id") long id, Model model){
//        get employee from the service
        Employee employee = employeeService.getEmployeeById(id);
//        set employee as a model to pre-populate the form
        model.addAttribute("employee", employee);
        return "update";
    }



    //    delete and employees details
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){
        //        get employee from the service
        Employee employee = employeeService.getEmployeeById(id);
//        call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }


}
