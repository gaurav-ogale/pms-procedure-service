package com.citius.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citius.model.Procedures;
import com.citius.repository.ProcedureRepo;


@Component
public class ProcedureDAO  {
	
	@Autowired
	private ProcedureRepo procedureRepo;

	
	public List<Procedures> getAllProcedures() {
		return dbToJson(procedureRepo.findAll());
	}
	
	public Procedures getProcedureByCode(String pCode) {

		return procedureRepo.getProcedureByProcedureCode(pCode);
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

	public List<Procedures> getProcedureByKeyword(String keyword) {
		// TODO Auto-generated method stub
		//System.out.println(procedureRepo.getProcedureByKeyword(keyword));
		List<Procedures> procList = procedureRepo.getProcedureByKeyword(keyword);
		return dbToJson(procList);
	}
	
	
	
}
