package com.employee_managemet_system.EmployeeService;

import com.employee_managemet_system.Model.Admin;


public interface AdminService {
 void addUser(Admin admin);

 Admin getAdminByEmail(String email);
}
