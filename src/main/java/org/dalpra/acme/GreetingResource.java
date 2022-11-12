package org.dalpra.acme;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dalpra.acme.dd4bfa.user.entity.User;

@ApplicationScoped
@Path("/hello")
public class GreetingResource {

	@Inject
    EntityManager em;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String hello() {
        //return "Hello RESTEasy";
    	User user = new User();
    	
    	user.setFirstName("Daniele");
		user.setLastName("Dal Prà");
		user.setEmail("d.dalpra86@gmail.com");
		user.setUserCreation("aaaa");
		user.setUserUpdating("bbbb");
		user.setDob(LocalDate.parse("1986-08-06"));
		
		em.persist(user);
		
		return user.toString();
    }
}