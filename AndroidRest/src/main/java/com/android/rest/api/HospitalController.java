package com.android.rest.api;

import com.android.rest.domain.Hospital;
import com.android.rest.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;


@RestController
@RequestMapping(path="/",produces="application/json")
public class HospitalController {
	
	private HospitalService hospitalService;
	
	@Autowired
	public HospitalController(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}


	@GetMapping
	public Iterable<Hospital> hospitals()
	{
		return hospitalService.findAll();
	}
	@GetMapping("/hospitals")
	public Iterable<Hospital> allHospital()
	{
		return hospitalService.findAll();
	}

	@GetMapping("/hospitals/{id}")
	public Optional<Hospital> oneHospital(@PathVariable("id") Long id)
	{
		return hospitalService.findById(id);
	}


	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Hospital createHospital(@RequestBody Hospital hospital) {
		return hospitalService.save(hospital);
	}
	
	
}
