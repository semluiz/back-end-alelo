package com.alelo.restapi.service.serviceImpl;

import com.alelo.restapi.model.Vehicle;
import com.alelo.restapi.repository.VehicleRepository;
import com.alelo.restapi.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleServiceImplements implements VehicleService {
    @Autowired
    VehicleRepository repository;


    @Override
    public Vehicle save(Vehicle vehicle) {
        try {
            return repository.save(vehicle);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }

    @Override
    public Page<Vehicle> findAllPaged(Pageable pageable) {
        try {
            return repository.findAll(pageable);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }


    @Override
    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public Vehicle findById(Integer id) {
        try {
            return repository.findById(id).get();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public Vehicle udpate(Vehicle vehicle) {
        try {
            return repository.save(vehicle);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<Vehicle> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
