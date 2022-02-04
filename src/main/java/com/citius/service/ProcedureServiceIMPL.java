package com.citius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citius.dao.ProcedureDAO;
import com.citius.model.Procedures;
import com.citius.repository.ProcedureRepo;

@Component
public class ProcedureServiceIMPL implements ProcedureService{

	@Autowired
	public ProcedureDAO procedureDAO;

	@Autowired
	ProcedureRepo procedureRepo;


	@Override
	public List<Procedures> getAllProcedures() {
		// TODO Auto-generated method stub
		return procedureDAO.getAllProcedures();

	}



	@Override
	public Procedures getProcedureByCode(String procedure_code) {
		// TODO Auto-generated method stub
		return procedureDAO.getProcedureByCode(procedure_code);
	}

	@Override
	public List<Procedures> getProcedureByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return procedureDAO.getProcedureByKeyword(keyword);
	}



}
