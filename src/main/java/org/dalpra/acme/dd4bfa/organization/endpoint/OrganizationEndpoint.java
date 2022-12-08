package org.dalpra.acme.dd4bfa.organization.endpoint;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dalpra.acme.dd4bfa.organization.entity.Organization;
import org.dalpra.acme.dd4bfa.organization.resource.OrganizationResource;


@Path("/api/organizations")
public class OrganizationEndpoint {

	@Inject
	OrganizationResource organizationResource;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public List<Organization> getOrganizations(){
		return organizationResource.getOrganizations();
	}
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Organization getOrganization(@PathParam("id") UUID id) {
        return organizationResource.getOrganization(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Organization updateOrganization(@PathParam("id") UUID id, Organization o) {
    	return organizationResource.updateOrganization(id, o);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Organization addOrganization(Organization o) {
        return organizationResource.addOrganizzation(o);
    }
    
    /*@POST
    @Path("/{id}/user/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Organization organizationUser(@PathParam("id") UUID id,@PathParam("idUser") UUID idUser) {
    	
    }*/

	@DELETE
    @Path("/{id}")
    public void deleteOrganization(@PathParam("id") UUID id) {
		organizationResource.deleteOrganization(id);
    }
}
