package com.employee_managemet_system.EmployeeService;

import com.employee_managemet_system.EmployeeRepository.AdminRepository;
import com.employee_managemet_system.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
     AdminRepository adminRepository;

    public void save(Admin admin){
    this.adminRepository.save(admin);
    }

    public void addUser(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin getAdminByEmail(String email) {
        return adminRepository.getAdminByEmail(email);
    }

    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.getAdminByEmailAndPassword(email, password);
    }

}
