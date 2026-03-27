package br.com.carstore.dto;

import java.util.List;

public class CarResponsyBody {

    private CarDTO car;
    public CarResponseBody (List<CarDTO> allcars ){
        this.cars = cars;
    }




    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }
}
