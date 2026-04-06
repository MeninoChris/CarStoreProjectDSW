package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.service.CarService;
import br.com.carstore.service.CarServiceImpl;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CarService service;

    @Autowired
    public HomeController(CarService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String createCar(@Valid CarDTO carDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        service.save(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String getCars(Model model) {
        model.addAttribute("cars", service.findAll());
        return "dashboard";
    }

    // rota de exclusão
    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/cars";
    }

    // rota de edição: carrega dados no formulário
    @GetMapping("/cars/edit/{id}")
    public String editCarForm(@PathVariable String id, Model model) {
        CarDTO carDTO = service.findById(id);
        if (carDTO == null) {
            return "redirect:/cars";
        }
        model.addAttribute("carDTO", carDTO);
        return "index";
    }

    // rota de atualização
    @PostMapping("/cars/update/{id}")
    public String updateCar(@PathVariable String id, @Valid CarDTO carDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        service.update(id, carDTO);
        return "redirect:/cars";
    }
}