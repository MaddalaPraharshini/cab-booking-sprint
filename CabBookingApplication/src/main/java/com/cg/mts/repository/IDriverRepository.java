package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.dao.IDriverDao;
import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;

@Repository("dDao")
public interface IDriverRepository extends IDriverDao,JpaRepository<Driver, Integer>{
	/*
	 * 
	 * public Driver insertDriver(Driver driver); public Driver updateDriver(Driver
	 * driver)throws DriverNotFoundException; public Driver deleteDriver(int
	 * driverId)throws DriverNotFoundException; public Driver viewDriver(int
	 * driverId)throws DriverNotFoundException; public
	 * List<Driver>viewBestDrivers()throws DriverNotFoundException;
	 * 
	 * 
	 */
	

}