package com.java.bahriddin.applearningcenter.controller;

import com.java.bahriddin.applearningcenter.entity.Course;
import com.java.bahriddin.applearningcenter.enums.Role;
import com.java.bahriddin.applearningcenter.service.EduStackService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

    private final EduStackService stackService;

    @GetMapping("/create/student")
    public String createStudentPage(Model model) {

        List<Course> stackList = stackService.getAll();
        model.addAttribute("stackList",stackList);

        List<Role> roles = Arrays.stream(Role.values()).toList();
        model.addAttribute("roles", roles);

        return "/admin/student-add";
    }
    @GetMapping("/get/students")
    public String getAll(Model model) {

        List<Course> stackList = stackService.getAll();
        model.addAttribute("stackList",stackList);

        List<Role> roles = Arrays.stream(Role.values()).toList();
        model.addAttribute("roles", roles);

        return "/admin/student-add";
    }



    @GetMapping("/create/mentor")
    public String createMentorPage(Model model) {
        return "/admin/mentor-add";
    }






}