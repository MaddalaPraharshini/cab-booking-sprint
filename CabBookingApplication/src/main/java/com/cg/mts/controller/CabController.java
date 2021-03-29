package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.service.ICabService;

@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	ICabService iCabService;

	@PostMapping
	public Cab insertCab(@RequestBody Cab cab) {
		return iCabService.insertCab(cab);
	}

	@PutMapping
	public Cab updateCab(@RequestBody Cab cab) throws CabNotFoundException {
		Cab cabCheck = null;
		Cab c = null;
		try {
			cabCheck = iCabService.getCabById(cab.getCabId());
			c = iCabService.updateCab(cab);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Update");
		}
		return c;
	}

	@DeleteMapping
	public Cab deleteCab(Cab cab) throws CabNotFoundException {
		Cab cabCheck = null;
		Cab c = null;
		try {
			cabCheck = iCabService.getCabById(cab.getCabId());
			c = iCabService.deleteCab(cab);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Delete");
		}
		return c;
	}

	@GetMapping(value = "type/{carType}")
	public List<Cab> viewCabsOfType(String carType) {
		return iCabService.viewCabsOfType(carType);
	}

	@GetMapping(value = "/count/{carType}")
	public int countCabsOfType(@PathVariable String carType) {
		return iCabService.countCabsOfType(carType);
	}

}
