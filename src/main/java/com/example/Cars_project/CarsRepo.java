package com.example.Cars_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepo extends JpaRepository<Car,Long> {
}
