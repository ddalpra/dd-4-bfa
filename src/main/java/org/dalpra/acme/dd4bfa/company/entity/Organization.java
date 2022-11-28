package org.dalpra.acme.dd4bfa.company.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.dalpra.acme.dd4bfa.base.entity.EntityBase;

@Entity
@Table(name="organization")
public class Organization extends EntityBase{

	private String ragioneSociale;

	public Organization(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating, String ragioneSociale) {
		super(timestampCreation, timestampUpdating, userCreation, userUpdating);
		this.ragioneSociale = ragioneSociale;
	}

	public Organization() {
		super();
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	
	
	
	
}
