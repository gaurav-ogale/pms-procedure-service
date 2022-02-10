package com.citius.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citius.dao.ProcedureDAO;
import com.citius.exception.ProcedureException;
import com.citius.model.Procedures;
import com.citius.repository.ProcedureRepo;

@Component
public class ProcedureServiceIMPL implements ProcedureService{

	@Autowired
	public ProcedureDAO procedureDAO;

	@Autowired
	ProcedureRepo procedureRepo;


	@Override
	public List<Procedures> getAllProcedures() throws ProcedureException {
		// TODO Auto-generated method stub
		List<Procedures> list = new ArrayList<>();
		try {
			list = procedureDAO.getAllProcedures();
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new ProcedureException(e.getMessage());
		}
		return list;
	}



	@Override
	public Procedures getProcedureByCode(String procedure_code) throws ProcedureException {
		// TODO Auto-generated method stub
		Procedures p = new Procedures();
		try {
			p = procedureDAO.getProcedureByCode(procedure_code);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new ProcedureException(e.getMessage());
		}
		return p;
	}

	@Override
	public List<Procedures> getProcedureByKeyword(String keyword) throws ProcedureException {
		// TODO Auto-generated method stub
		List<Procedures> list = new ArrayList<>();
		try {
			list = procedureDAO.getProcedureByKeyword(keyword);
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new ProcedureException(e.getMessage());
		}
		return list;
	}



}
