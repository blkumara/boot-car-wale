package com.ty.bootcarwaleapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	CarRepository carRepository;

	@PostMapping("/carsaved")
	public Car saveCar(@RequestBody Car car) {
		return carRepository.save(car);
	}

	@PostMapping("/getallcar")
	public List<Car> getAllCar() {
		return carRepository.findAll();
	}

	@PostMapping("/getcarid/{id}")
	public Car getCarById(@PathVariable int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isEmpty()) {
			System.out.println("No Car Found");
			return null;

		} else {
			return optional.get();
		}
	}

	@PostMapping("/deletecar")
	public String deleteCar(@RequestParam int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isEmpty()) {
			return "no car";
		} else {
			Car car = optional.get();
			carRepository.delete(car);
			return "deleted";
		}

	}

	@PostMapping("/updatecar/{id}")
	public Car updateCar(@RequestBody Car car, @PathVariable int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return carRepository.save(car);

		}
	}

}
