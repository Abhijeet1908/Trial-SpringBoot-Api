package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	
	public List<Car> findByName(String name);
	
	
	@Query("SELECT c FROM Car c WHERE c.name=:name AND c.brand=:brand")
	public List<Car> validateCar(@Param("name")String name,@Param("brand")String brand );

}
