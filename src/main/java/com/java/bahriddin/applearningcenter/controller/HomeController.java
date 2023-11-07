package uz.pdp.springsecuritystarter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.pdp.springsecuritystarter.entity.car.Car;
import uz.pdp.springsecuritystarter.repository.CarRepository;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class HomeController {

    private final CarRepository carRepository;

    @GetMapping("/home")
    public String homePage(){

        return "/auth/home";
    }
    @GetMapping("/car")
    public String carPage(Model model) {

        List<Car> all = carRepository.findAll();
        model.addAttribute("carList", all);
        return "car/car-list";
    }

    @GetMapping("/admin")
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




}
