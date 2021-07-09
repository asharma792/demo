package com.example.demo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long>
{
    Driver findByUsername(final String username);

	List<Driver> findByIdAndCabTypeId(int carTypeID, int driverID);


    //List<Driver> findByOnlineStatus(OnlineStatus onlineStatus);
}