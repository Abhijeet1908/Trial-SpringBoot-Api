package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Car;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.service.CarService;

@RestController
public class Controller {
	@Autowired
	CarService service;

	@PostMapping("/car")
	public ResponseStructure<Car> saveCar(@RequestBody Car car) {

		return service.saveCar(car);
	}

	@PutMapping("/car")
	public ResponseStructure<Car> updateCar(@RequestBody Car car) {
		return service.saveCar(car);
	}
	@GetMapping("/car")
	public List<Car> findAllCar() {
		return service.findAllCar();
	}

	@GetMapping("/car/{id}")
	public ResponseStructure<Car> findCarById(@PathVariable("id") int id) {
		return service.findCarById(id);
	}

	@DeleteMapping("/car/{id}")
	public ResponseStructure<Car> deleteCarByid(@PathVariable("id") int id) {
		return service.deleteCarById(id);
	}
	@GetMapping("/carbyname")
	public List<Car> findCarByName(@RequestParam("name") String name){
		return service.findCarByName(name);
	}
	@GetMapping("/validate")
	public List<Car> validateCar(@RequestParam("name")String name, @RequestParam("brand") String brand){
		return service.validateCar(name, brand);
	}
}
