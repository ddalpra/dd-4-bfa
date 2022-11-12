package org.dalpra.acme.dd4bfa.user.endpoint;

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

import org.dalpra.acme.dd4bfa.user.entity.User;
import org.dalpra.acme.dd4bfa.user.resource.UserResource;

@Path("/api/users")
public class UserEndpoint {

	@Inject
	UserResource userResource;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getContacts() {
        return userResource.getUsers();
    }
	
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") UUID id) {
        return userResource.getUser(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateContact(@PathParam("id") UUID id, User u) {
    	userResource.updateUser(id, u);
    	return u;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User addContact(User u) {
        return userResource.addUser(u);
    }

    @DELETE
    @Path("/{id}")
    public void deleteContact(@PathParam("id") UUID id) {
    	userResource.deleteUser(id);
    }
	
}
