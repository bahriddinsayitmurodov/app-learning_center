package com.java.bahriddin.applearningcenter.controller;

import com.java.bahriddin.applearningcenter.dto.AuthUserDto;
import com.java.bahriddin.applearningcenter.dto.StudentDto;
import com.java.bahriddin.applearningcenter.entity.authuser.AuthUser;
import com.java.bahriddin.applearningcenter.entity.stack.EduStack;
import com.java.bahriddin.applearningcenter.entity.student.Student;
import com.java.bahriddin.applearningcenter.enums.Role;
import com.java.bahriddin.applearningcenter.service.AuthUserService;
import com.java.bahriddin.applearningcenter.service.EduStackService;
import com.java.bahriddin.applearningcenter.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final StudentService studentService;
    private final EduStackService stackService;
    private final AuthUserService userService;
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/create/student")
    public String createStudentPage(Model model) {

        List<EduStack> stackList = stackService.getAll();
        model.addAttribute("stackList",stackList);

        List<Role> roles = Arrays.stream(Role.values()).toList();
        model.addAttribute("roles", roles);

        return "/admin/student-add";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/create/mentor")
    public String createMentorPage(Model model) {

        return "/admin/mentor-add";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/create/student")
    public String createStudent(@ModelAttribute StudentDto studentDto) {
        System.out.println("student = " + studentDto);
        studentService.create(studentDto);
        return "redirect:/admin/get/students";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/create/mentor")
    public String createMentor(@ModelAttribute AuthUserDto authUserDto) {
        System.out.println(authUserDto);
        userService.create(authUserDto);
        return "redirect:/admin/get/mentors";
    }


    @GetMapping("/get/students")
    public String getAll(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "/admin/student-list";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/get/mentors")
    public String getAllMentors(Model model) {
        List<AuthUser> mentors =  userService.getAllMentors();

        model.addAttribute("mentors", mentors);

        return "/admin/mentor-list";
    }

    @GetMapping("/delete/student/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.deleteById(id);
        return "redirect:/admin/get/students";
    }
    @GetMapping("/update/student/{id}")
    public String updateStudent(@PathVariable Integer id, Model model) {
        Student updatingStudent = studentService.getById(id);
        System.out.println("updatingStudent = " + updatingStudent);
        model.addAttribute("updatingStudent",updatingStudent);

        return "/admin/student-update";
    }
    @PostMapping("/update/student/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute StudentDto studentDto) {
        System.out.println("studentDto = " + studentDto);
        studentService.update(id, studentDto);

        return "redirect:/admin/get/students";
    }

    /*@GetMapping("/update/student/{id}")
    public String updateStudent(@PathVariable Integer id, Model model, @ModelAttribute StudentDto studentDTO) {
        // TODO: 01/11/2023
        return "redirect:/admin/get/students";
    }*/
}