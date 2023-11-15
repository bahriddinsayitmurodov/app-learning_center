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


}

