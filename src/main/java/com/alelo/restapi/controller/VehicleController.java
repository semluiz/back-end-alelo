package com.alelo.restapi.controller;

import com.alelo.restapi.model.Vehicle;
import com.alelo.restapi.service.serviceImpl.VehicleServiceImplements;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping(value = "/api")
@Api(value = "Rest API Alelo")
@JsonIgnoreProperties
public class VehicleController {

    @Autowired
    VehicleServiceImplements service;

    @GetMapping("/vehicles-paged")
    @ApiOperation("lista os veículos com paginação e filtro")
    public Page<Vehicle> list(Pageable pageable) {
        return service.findAllPaged(pageable);
    }

    @GetMapping("/vehicles")
    @ApiOperation("lista os veículos com paginação e filtro")
    public List<Vehicle> listAll() {
        return service.findAll();
    }

    @GetMapping("/vehicle/{id}")
    @ApiOperation("mostra o veículo escolhido pelo id")
    public Vehicle findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/vehicle")
    @ApiOperation("salva um novo veículo")
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }

    @DeleteMapping("/vehicle/{id}")
    @ApiOperation("remove o veículo escolhido pelo ID")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);


    }

    @PutMapping("/vehicle")
    @ApiOperation("atualiza as informações de um veículo")
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return service.udpate(vehicle);
    }

}
