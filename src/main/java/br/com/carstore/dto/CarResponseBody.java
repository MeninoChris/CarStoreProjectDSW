package br.com.carstore.dto;

import java.util.List;

public class CarResponseBody {

    private List<CarDTO> cars;

    public CarResponseBody(List<CarDTO> allCars) {
        this.cars = allCars;
    }

    private CarDTO car;

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }
}
