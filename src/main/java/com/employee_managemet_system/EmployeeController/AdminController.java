package com.employee_managemet_system.EmployeeController;


import com.employee_managemet_system.EmployeeService.AdminService;
import com.employee_managemet_system.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")

public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping
    public String showAdminRegistrationForm(Model model){
        model.addAttribute("admin", new Admin());
        return "adminLogin";
    }

    @PostMapping()
    public String signUp(Admin admin, Model model) {
        System.err.println(admin);
        Admin adminRegistered = adminService.getAdminByEmail(admin.getEmail());
        if (adminRegistered != null) {
            model.addAttribute("failed", "User with Email Already exist");
            return "adminLogin";
        }
        adminService.addUser(admin);
        return "redirect:/registration/login";
    }

    @GetMapping("/login")
    public String showAdminLoginForm(){
        return "login";
    }


    @PostMapping("/employeeList")
    public String employeeList(){
        return "redirect:/";
    }


}
