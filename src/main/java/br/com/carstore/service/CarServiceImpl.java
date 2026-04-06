package br.com.carstore.service;

import br.com.carstore.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {
    private List<CarDTO> cars = new ArrayList<>();

    @Override
    public List<CarDTO> findAll() {
        return cars;
    }

    @Override
    public void save(CarDTO carDTO) {

        if (carDTO.getId() == null || carDTO.getId().isEmpty()) {
            carDTO.setId(UUID.randomUUID().toString());
        }
        cars.add(carDTO);
    }

    @Override
    public void deleteById(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    @Override
    public void update(String id, CarDTO carDTO) {

        cars.replaceAll(car -> car.getId().equals(id) ? carDTO : car);
    }

    @Override
    public CarDTO findById(String id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}