package uz.pdp.springsecuritystarter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springsecuritystarter.dto.AuthUserDto;
import uz.pdp.springsecuritystarter.service.AuthUserService;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {

    private final AuthUserService authUserService;

    @GetMapping(value = "/login")
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

    @PostMapping("/forgot-password")
    public String recoverPassword(@RequestParam("email") String email) {

        //todo
        authUserService.recoverPassword(email);
        return "redirect:auth/login";
    }

    @PostMapping("/register")
    public String create(@ModelAttribute AuthUserDto userDto) {
        authUserService.create(userDto);
        return "redirect:auth/login";
    }


}
