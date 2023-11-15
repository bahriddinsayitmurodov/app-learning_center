package com.java.bahriddin.applearningcenter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public String homePage(){
        return "/admin/adminPage";
    }


}

