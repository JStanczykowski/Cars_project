package com.example.Cars_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarsController {
    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/cars")
    public String ListCars(Model model){

        model.addAttribute("cars",carService.getAllCars());
        return "cars";
    }
    @GetMapping("/cars/new")
    public String createCars(Model model){
        Car car = new Car();
        model.addAttribute("car",car);
        return "add_cars";
    }
    @PostMapping("/cars")
    public String saveCars(@ModelAttribute("car") Car car ){
        carService.saveCar(car);
        return "redirect:/cars";
    }
    @GetMapping("/cars/edit/{id}")
    public String editCarForm(@PathVariable Long id,Model model){
        model.addAttribute("car",carService.getCarById(id));
        return "edit_cars";
    }
    @PostMapping("/cars/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute("car") Car car,Model model){
        Car existingCar = carService.getCarById(id);
        existingCar.setId(id);
        existingCar.setMark(car.getMark());
        existingCar.setColor(car.getColor());
        existingCar.setModel(car.getModel());
        carService.updateCar(existingCar);
        return "redirect:/cars";
    }
    @GetMapping("/cars/{id}")
    public String deleteCar(@PathVariable Long id){
        carService.deleteCarsById(id);
        return "redirect:/cars";
    }
}
