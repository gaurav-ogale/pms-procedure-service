package com.citius.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citius.exception.ProcedureException;
import com.citius.model.Procedures;
import com.citius.repository.ProcedureRepo;


@Component
public class ProcedureDAO  {
	
	@Autowired
	private ProcedureRepo procedureRepo;

	
	public List<Procedures> getAllProcedures() throws ProcedureException {
		List<Procedures> list = procedureRepo.findAll();
		if(list.isEmpty())
			throw new ProcedureException("No Procedures Found");
		else
			return dbToJson(list);
	}
	
	public Procedures getProcedureByCode(String pCode) throws ProcedureException {
		
		Procedures p = procedureRepo.getProcedureByProcedureCode(pCode);
		if(p.equals(null))
			throw new ProcedureException("No Procedure for given procedure code");
		else
			return p;
	}
	

	public List<Procedures> getProcedureByKeyword(String keyword) throws ProcedureException {
		// TODO Auto-generated method stub
		List<Procedures> procList = procedureRepo.getProcedureByKeyword(keyword);
		if(procList.isEmpty())
			throw new ProcedureException("No Suggestions....");
		else
			return dbToJson(procList);
	}
	
	private List<Procedures> dbToJson(List<Procedures> procedureList) {
		List<Procedures> jsonList = new ArrayList<>();
		for (Procedures p : procedureList) {
			Procedures procedure = new Procedures();
			procedure.setProcedureCode(p.getProcedureCode());
			procedure.setProcedureDescription(p.getProcedureDescription());
			procedure.setProcedureIsDepricated(p.getProcedureIsDepricated());
			jsonList.add(procedure);
		}
		return jsonList;
	}
	
	
	
}
