package com.citius.service;

import java.util.List;

import com.citius.exception.ProcedureException;
import com.citius.model.Procedures;


public interface ProcedureService {

	public Procedures getProcedureByCode(String procedure_code) throws ProcedureException;
	
	public List<Procedures> getAllProcedures() throws ProcedureException;
	
	public List<Procedures> getProcedureByKeyword(String keyword) throws ProcedureException;

}
