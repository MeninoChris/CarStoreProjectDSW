package br.com.carstore.service;


import br.com.carstore.dto.CarDTO;
import java.util.List;

public interface CarService {

    List<CarDTO> findAll();

    void save(CarDTO carDTO);

    void deleteById(String id);

    void update(String id, CarDTO carDTO);

}