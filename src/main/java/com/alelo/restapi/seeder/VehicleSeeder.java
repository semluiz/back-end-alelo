package com.alelo.restapi.seeder;

import com.alelo.restapi.model.Vehicle;
import com.alelo.restapi.service.serviceImpl.VehicleServiceImplements;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VehicleSeeder {
    @Autowired
    VehicleServiceImplements vehicleService;


    @EventListener
    private void seedCartorio(ContextRefreshedEvent event){
        try{
            log.info("Criando veículos.......");
            creatingVehicle();
        }catch (Exception e){
            e.getMessage();
        }

    }

    private void creatingVehicle() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setModel("BMW series 8");
        vehicle1.setColor("Branco");
        vehicle1.setPlate("QUAS-894");
        vehicle1.setStatus(true);
        vehicleService.save(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setModel("Mercedes Benz");
        vehicle2.setColor("Blue");
        vehicle2.setPlate("JMO-7954");
        vehicle2.setStatus(true);
        vehicleService.save(vehicle2);
    }

}
