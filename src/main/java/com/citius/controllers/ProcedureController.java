package com.citius.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citius.model.Procedures;
import com.citius.service.ProcedureServiceIMPL;

@RestController
public class ProcedureController {
	
	@Autowired
	public ProcedureServiceIMPL procedureService;
	
	@Autowired
	public Environment environment;
	
	
	@GetMapping("/getByCode/{procedure_code}")
	public ResponseEntity<Procedures> getProcedureByCode(@PathVariable String procedure_code){
		
		Procedures p = new Procedures();
		try {
			p = procedureService.getProcedureByCode(procedure_code);
		}
		catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Procedures>(p, HttpStatus.OK);
		
	}
	
	@GetMapping("/getByKeyword/{keyword}")
	public ResponseEntity<List<Procedures>> getProcedureByKeyword(@PathVariable String keyword) {
		List<Procedures> list = new ArrayList<>();
		try {
			list = procedureService.getProcedureByKeyword(keyword.toLowerCase());
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Procedures>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Procedures>> getAll(){
		List<Procedures> list = new ArrayList<>();
		try {
			list = procedureService.getAllProcedures();
		}
		catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Procedures>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/depricatedOrNot/{isDepricated}")
	public ResponseEntity<List<Procedures>> getByIsDepricated(@PathVariable Boolean isDepricated){
		List<Procedures> list = new ArrayList<Procedures>();
		try {
			list = procedureService.getByIsDepricated(isDepricated);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Procedures>>(list, HttpStatus.OK);
	}
	
	@PatchMapping("/updateProcedure")
	public ResponseEntity<?> updateProcedure(@RequestBody Procedures proc){
		
		try {
			procedureService.updateProcedure(proc);
		}
		catch (Exception e) {
			System.out.println(e.getClass());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
