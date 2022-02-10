package com.citius.procedures;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.citius.exception.ProcedureException;
import com.citius.model.Procedures;
import com.citius.service.ProcedureService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProcedureServiceTest {

	public static final String DUMMY_ID = "ABC";
	public static final String DUMMY_DESCRIPTION = "Abc is a procedure";
	public static final boolean DUMMY_ISDEPRICATED = false;

	@Mock
	ProcedureService procedureService;

	@Test
	public void getById_happyCase() throws ProcedureException {

		Procedures proc = new Procedures();
		proc.setProcedureCode(DUMMY_ID);
		proc.setProcedureDescription(DUMMY_DESCRIPTION);
		proc.setProcedureIsDepricated(DUMMY_ISDEPRICATED);

		when(procedureService.getProcedureByCode(any())).thenReturn(proc);
		Procedures p = procedureService.getProcedureByCode("");
		assertEquals(p, proc);

	}

	@Test(expected = ProcedureException.class)
	public void getById_Exception() throws ProcedureException {

		when(procedureService.getProcedureByCode(any())).thenThrow(new ProcedureException("Exception"));
		procedureService.getProcedureByCode("");

	}

}
