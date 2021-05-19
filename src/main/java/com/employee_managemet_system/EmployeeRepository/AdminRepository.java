package com.employee_managemet_system.EmployeeRepository;

import com.employee_managemet_system.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>{

    Admin getAdminByEmailAndPassword(String email, String password);

    Admin getAdminByEmail(String email);
}
