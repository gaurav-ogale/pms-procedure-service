package com.citius.service;

import java.util.List;

import com.citius.model.Procedures;


public interface ProcedureService {

	public Procedures getProcedureByCode(String procedure_code);
	
	public List<Procedures> getAllProcedures();
	
	public List<Procedures> getProcedureByKeyword(String keyword);

}
