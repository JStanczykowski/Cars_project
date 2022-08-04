package com.example.Cars_project;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{
    private CarsRepo carsRepo;

    public CarServiceImpl(CarsRepo carsRepo) {
        this.carsRepo = carsRepo;
    }
    @Override
    public List<Car> getAllCars(){
        return carsRepo.findAll();
    }
    @Override
    public Car saveCar(Car car){
        return carsRepo.save(car);
    }
    @Override
    public Car getCarById(long id){
        return carsRepo.findById(id).get();
    }
    @Override
    public Car updateCar(Car car){
        return carsRepo.save(car);
    }
    @Override
    public void deleteCarsById(long id){
        carsRepo.deleteById(id);
    }
}
