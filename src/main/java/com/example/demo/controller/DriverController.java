package com.example.demo.controller;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CarBookingRequest;
import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;



/**
 * All operations with a driver will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/drivers")
public class DriverController
{

    @Autowired
	private DriverService driverService;





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Driver createDriver(@RequestBody Driver driverDTO) 
    {

        return driverService.create(driverDTO);
    }

    
    @PutMapping("/{driverId}")
    public void updateLocation(
         @PathVariable long driverId, @RequestParam double longitude, @RequestParam double latitude)
    {
        driverService.updateLocation(driverId, longitude, latitude);
    }


    

    @PostMapping("/search")
    public List<DriverDTO> findDriversByFilterCriteria(@RequestBody CarBookingRequest req)
    {
        return driverService.findDriversByFilterCriteria(req);
    }
}