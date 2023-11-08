package com.java.bahriddin.applearningcenter.controller;

import com.java.bahriddin.applearningcenter.dto.AuthUserDto;
import com.java.bahriddin.applearningcenter.service.AuthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {

    private final AuthUserService authUserService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("errorMessage",error);
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "auth/register";
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        System.out.println("Forgot Password");
        return "auth/f";
    }

    @PostMapping("/register")
    public String create(@ModelAttribute AuthUserDto userDto) {
        authUserService.create(userDto);
        return "redirect:auth/login";
    }


}
