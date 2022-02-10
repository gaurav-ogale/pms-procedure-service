package com.citius.procedures;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.citius.dao.ProcedureDAO;
import com.citius.exception.ProcedureException;
import com.citius.model.Procedures;
import com.citius.repository.ProcedureRepo;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProcedureDAOTest {
	
	public static final String DUMMY_ID = "ABC";
	public static final String DUMMY_DESCRIPTION = "Abc is a procedure";
	public static final boolean DUMMY_ISDEPRICATED = false;
	
	@Mock
	ProcedureDAO procedureDAO;
	
	@Mock
	ProcedureRepo procedureRepo;
	
	@Test
	public void getByKeyword_HappyCase() throws ProcedureException {
		Procedures proc = new Procedures();
		proc.setProcedureCode(DUMMY_ID);
		proc.setProcedureDescription(DUMMY_DESCRIPTION);
		proc.setProcedureIsDepricated(DUMMY_ISDEPRICATED);
		List<Procedures> list = new ArrayList<>();
		list.add(proc);
		when(procedureDAO.getProcedureByKeyword(any())).thenReturn(list);
		List<Procedures> p = procedureDAO.getProcedureByKeyword("sinus");
		assertEquals(p, list);

	}
	
	@Test(expected = ProcedureException.class)
	public void getByKeyword_Exception() throws ProcedureException {

		when(procedureDAO.getProcedureByKeyword(any())).thenThrow(new ProcedureException("Exception"));
		procedureDAO.getProcedureByKeyword("");
		verify(procedureRepo, times(1));

	}

}
