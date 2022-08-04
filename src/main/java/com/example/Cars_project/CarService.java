package com.example.Cars_project;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car saveCar(Car car);
    Car getCarById(long id);
    Car updateCar(Car car);
    void deleteCarsById(long id);
}
