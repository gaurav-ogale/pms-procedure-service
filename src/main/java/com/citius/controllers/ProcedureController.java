package com.citius.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.citius.model.Procedures;
import com.citius.service.ProcedureServiceIMPL;

@RestController
public class ProcedureController {
	
	@Autowired
	public ProcedureServiceIMPL procedureService;
	
	
	@GetMapping("/getByCode/{procedure_code}")
	public Procedures getProcedureByCode(@PathVariable String procedure_code){
		
		System.out.println("inside Controller");
			return procedureService.getProcedureByCode(procedure_code);
		
	}
	
	@GetMapping("/getByKeyword/{keyword}")
	public List<Procedures> getProcedureByKeyword(@PathVariable String keyword) {
		return procedureService.getProcedureByKeyword(keyword);
	}
	
	@GetMapping("/get")
	public List<Procedures> getAll(){
		return procedureService.getAllProcedures();
	}
	
}
