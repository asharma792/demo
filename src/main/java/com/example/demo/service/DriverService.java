package com.example.demo.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.CarBookingRequest;
import com.example.demo.entity.Driver;
import com.example.demo.entity.GeoCoordinate;
import com.example.demo.repository.DriverRepository;

@Service
public class DriverService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(DriverService.class);



    @Autowired
    private DriverRepository driverRepository;





    public Driver create(Driver driverDO) 
    {
        Driver driver = null;
        try
        {
            driver = driverRepository.save(driverDO);
        }
        catch (DataAccessException e)
        {
            LOG.error("Error Saving Driver", e);
           
        }
        return driver;
    }

    

    @Transactional
    public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException
    {
        Driver driverDO = findDriverChecked(driverId);
        driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
        driverRepository.save(driverDO);
    }

    public void findDriversByFilterCriteria(CarBookingRequest req) throws EntityNotFoundException
    {
        try
        {
            List<Driver> findByIdAndCabTypeId = driverRepository.findByIdAndCabTypeId(req.getCarTypeID(), req.getDriverID());
            
            Set<Integer> sorted = new LinkedHashSet<>();

            for (Driver driver : findByIdAndCabTypeId) {
                sorted.add(Math.sqrt( Math.pow((driver.getCoordinate().getLongitude()-req.getCoordinate().getLongitude()), 2) 
                		+ Math.pow((driver.getCoordinate().getLatitude()-req.getCoordinate().getLatitude()), 2)));
			}

        sorted.get(0);
        }

    }
    
    
    private Driver findDriverChecked(Long driverId) throws EntityNotFoundException
    {
        return driverRepository
            .findById(driverId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
    }






}
