package com.citius.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "procedures")
public class Procedures {
	
	@Id
	@Column(name="procedure_code")
	private String procedureCode;
	
	@Column(name="procedure_description")
	private String procedureDescription;
	
	@Column(name="procedure_is_depricated")
	private Boolean procedureIsDepricated;
	
	
	public String getProcedureCode() {
		return procedureCode;
	}
	
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	
	public String getProcedureDescription() {
		return procedureDescription;
	}
	
	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}
	
	public Boolean getProcedureIsDepricated() {
		return procedureIsDepricated;
	}
	
	public void setProcedureIsDepricated(Boolean procedureIsDepricated) {
		this.procedureIsDepricated = procedureIsDepricated;
	}
	
	

}
