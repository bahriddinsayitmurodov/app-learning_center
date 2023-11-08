package com.java.bahriddin.applearningcenter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public String homePage(){
        return "/admin/adminPage";
    }


  /*  @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String home() {
        return "admin_can_access";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String manager(){
        return "manager_can_access";
    }

    @GetMapping("/has_any_role")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'USER')")
    public String profile(){
        return "ADMIN, MANAGER, USER can see this page";
    }
*/



}

