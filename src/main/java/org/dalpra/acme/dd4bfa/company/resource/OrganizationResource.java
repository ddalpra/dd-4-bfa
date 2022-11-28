package org.dalpra.acme.dd4bfa.company.resource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.dalpra.acme.dd4bfa.company.entity.Organization;

@Singleton
public class OrganizationResource {
	
	@Inject
	EntityManager em;

	public List<Organization> getOrganization(){
		return em.createQuery("SELECT o FROM Organization o").getResultList();
	}
	
	public Organization getOrganization(UUID id) {
		return em.find(Organization.class, id);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public Organization addOrganizzation(Organization organization) {
		if(organization.getUserCreation()==null)
			organization.setUserCreation("utenteA");
		if(organization.getUserUpdating()==null) 
			organization.setUserUpdating("utenteA");
		if(organization.getTimestampCreation()==null)
			organization.setTimestampCreation(LocalDateTime.now());
		if(organization.getTimestampUpdating()==null)
			organization.setTimestampUpdating(LocalDateTime.now());
		
		em.persist(organization);
		return organization;
		
	}
	@Transactional(Transactional.TxType.REQUIRED)
	public Organization updateOrganization(UUID id, Organization organization) {
		Organization orgToUpdate = em.find(Organization.class, id);
		
		if(orgToUpdate!=null) {
			orgToUpdate.setRagioneSociale(organization.getRagioneSociale());
			orgToUpdate.setTimestampUpdating(LocalDateTime.now());
			orgToUpdate.setUserUpdating("utenteB");
			em.persist(orgToUpdate);
		}else {
			throw new RuntimeException("No such User available");
		}
		return orgToUpdate;
		
	}
	public void deleteOrganization(UUID id) {
		Organization organization = getOrganization(id);
		em.remove(organization);
	}
}
