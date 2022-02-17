package com.citius.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citius.model.Procedures;

//@Component
@Repository
public interface ProcedureRepo extends JpaRepository<Procedures,String> {
	
	@Query(value= "select * from procedures p where p.procedure_code = ?1",nativeQuery =true)
	public Procedures getProcedureByProcedureCode(String pcode);
	
	@Query(value = "select * from procedures p where lower(p.procedure_description) like %?1%" , nativeQuery = true)
	public List<Procedures> getProcedureByKeyword(String keyword);
	
	@Query(value = "select * from procedures p where p.procedure_is_depricated = ?1", nativeQuery = true)
	public List<Procedures> getByIsDepricated(Boolean isDepricated);
	
	@Modifying()
	@org.springframework.transaction.annotation.Transactional
	@Query(value = "update procedures  set procedure_is_depricated =?1 where procedure_code = ?2", nativeQuery = true)
	public int updateProcedure(Boolean isDepricated, String pCode);
		
}
