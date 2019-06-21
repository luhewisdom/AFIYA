package com.android.rest.api;

import com.android.rest.domain.Hospital;
import com.android.rest.domain.HospitalModel;
import com.android.rest.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/hospital",produces="application/json")
@CrossOrigin(origins="*")
public class HospitalController {


	
	private HospitalService hospitalService;
	
	@Autowired
	public HospitalController(HospitalService hospitalService) {
		this.hospitalService = hospitalService;
	}


	@GetMapping("/hospitals")
	public Iterable<HospitalModel> allHospital()
	{
		return HospitalModel.getHosoopitalModel((List<Hospital>) hospitalService.findAll());
	}

	@GetMapping("/hospitals/{id}")
	public HospitalModel oneHospital(@PathVariable("id") Long id)
	{
		return HospitalModel.getHospitalModel(hospitalService.findHospitalById(id));
	}

}
