package com.alelo.restapi;

import com.alelo.restapi.model.Vehicle;
import com.alelo.restapi.service.serviceImpl.VehicleServiceImplements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	VehicleServiceImplements service;

	@Test
	void contextLoads() {
	}

	@Test
	public void listVehiclesTest(){
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setModel("Mercedes Benz");
		vehicle1.setPlate("PUSP-789");
		vehicle1.setColor("White");
		vehicle1.setStatus(true);

		service.save(vehicle1);

		Assertions.assertEquals(vehicle1, vehicle1);
	}

	@Test
	public void findVehicleByIdTest(){
		Vehicle vehicle1 = service.findById(1);
		Assertions.assertNotNull(vehicle1);
	}

	@Test
	public void deleteVehicleByIdTest(){
		service.deleteById(2);
		Vehicle vehicle = service.findById(2);
		Assertions.assertNull(vehicle);
	}

	@Test
	public void updateVehicleTest(){
		Vehicle vehicle1 = service.findById(2);
		vehicle1.setStatus(false);
		service.udpate(vehicle1);
		Vehicle vehicle2 = service.findById(1);

		Assertions.assertNotEquals(vehicle1.getStatus(), vehicle2);
	}


	@Test
	public void saveVehicleTest(){
		Vehicle vehicle = new Vehicle();
		vehicle.setModel("Ferrari");
		vehicle.setPlate("MLYP-195");
		vehicle.setColor("Blue");
		vehicle.setStatus(true);
		service.save(vehicle);


		Vehicle vehicle2 =  service.findById(4);
		Assertions.assertEquals(vehicle, vehicle2);
	}

}
