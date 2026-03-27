package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.dto.CarResponseBody;
import br.com.carstore.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    private final CarService carService;

    public IndexController(CarService service) {
        this.carService = service;
    }

    @GetMapping("/api/cars")
    public ResponseEntity<CarResponseBody> home() {
        List<CarDTO> allCars = carService.findAll();
        CarResponseBody carResponseBody = new CarResponseBody(allCars);
        return ResponseEntity.ok(carResponseBody);
    }

    @PostMapping("/api/cars")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO car) {
        this.carService.save(car);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<CarDTO> deleteCar(@PathVariable String id) {
        this.carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cars/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String id, @RequestBody CarDTO carDTO) {
        this.carService.update(id, carDTO);
        return ResponseEntity.ok(carDTO);
    }
}