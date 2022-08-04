package com.example.Cars_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {
    private CarsRepo carsRepo;

    @Autowired
    public Start(CarsRepo carsRepo) {this.carsRepo= carsRepo; }
    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){
        Car car1 = new Car ("Honda","jazz",Color.BLACK);
        carsRepo.save(car1);

        Car car2 = new Car ("Opel","insignia",Color.RED);
        carsRepo.save(car2);

        Car car3 = new Car ("BMW","F36",Color.BLUE);
        carsRepo.save(car3);

        Iterable<Car> all = carsRepo.findAll();
        all.forEach(System.out::println);

        carsRepo.deleteById(1L);

    }
}
