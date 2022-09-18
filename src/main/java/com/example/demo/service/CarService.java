package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CarDao;
import com.example.demo.dto.Car;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.exception.NoDataForGivenIdFoundException;

@Service
public class CarService {
	@Autowired
	CarDao dao;

	public ResponseStructure<Car> saveCar(Car car) {
		Car c= dao.saveCar(car);
		ResponseStructure<Car> rs= new ResponseStructure<>();
		if(c!=null) {
			rs.setData(c);
			rs.setMessage("Data saved sucessfully and the data is as follows");
			rs.setStatusCode(HttpStatus.OK.value());
			return rs;
		}else {
			rs.setData(null);
			rs.setMessage("Something went wrong");
			rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
			return rs;
		}
		

	}
	public List<Car> findAllCar(){
		return dao.findAllCar();
	}
	public ResponseStructure<Car> findCarById(int id) {
		Car c= dao.findCarById(id);
		ResponseStructure<Car> rs= new ResponseStructure<>();
		if(c!=null) {
			rs.setData(c);
			rs.setMessage("Data found for given id");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return rs;
		}throw new NoDataForGivenIdFoundException("There is no data for such id");
	}
	public ResponseStructure<Car> deleteCarById(int id) {
		Car c= dao.deleteCarById(id);
		ResponseStructure<Car> rs= new ResponseStructure<>();
		if(c!=null) {
			rs.setData(c);
			rs.setMessage("Data  for given id deleted sucessfully and the data is as follows:");
			rs.setStatusCode(HttpStatus.FOUND.value());
			return rs;
			}throw new NoDataForGivenIdFoundException();
	}
	public List<Car> findCarByName(String name) {
		return dao.findCarByName(name);
		
	}
	public List<Car> validateCar(String name, String brand){
		return dao.validateCar(name, brand);
	}

}
