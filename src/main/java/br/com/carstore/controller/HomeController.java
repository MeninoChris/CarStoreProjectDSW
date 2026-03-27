package br.com.carstore.controller;
import br.com.carstore.dto.CarDTO;
import br.com.carstore.service.CarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CarServiceImpl service;

    public HomeController(CarServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<CarDTO> all = service.findAll();

        System.out.println("Criou um objeto " + service);
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String createCar(CarDTO carDTO, BindingResult result) {
        service.save(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        List<CarDTO> allCars = service.findAll();
        model.addAttribute("cars", allCars);
        return "dashboard";
    }
}