package com.alelo.restapi.service;

import com.alelo.restapi.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface VehicleService  {
    Vehicle save(Vehicle vehicle);

    Page<Vehicle> findAllPaged(Pageable pageable);

    void deleteById(Integer id);

    Vehicle findById(Integer id);

    Vehicle udpate(Vehicle vehicle);

    List<Vehicle> findAll();
}
