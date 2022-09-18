package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Car;
import com.example.demo.repository.CarRepository;

@Repository
public class CarDao {
	@Autowired
	CarRepository repository;

	public Car saveCar(Car car) {
		return repository.save(car);

	}

	public List<Car> findAllCar() {
		return repository.findAll();
	}

	public Car findCarById(int id) {
		Optional<Car> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Car deleteCarById(int id) {
		Car c = findCarById(id);
		if(c!=null) {
		 repository.delete(c);
		 return c;
		}
		return null;
	}
	public List<Car> findCarByName(String name) {
		return repository.findByName(name);
	}
	public List<Car> validateCar(String name, String brand){
		return repository.validateCar(name, brand);
	}
}
