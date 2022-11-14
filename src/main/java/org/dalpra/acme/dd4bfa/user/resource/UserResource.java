package org.dalpra.acme.dd4bfa.user.resource;
	
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.dalpra.acme.dd4bfa.user.entity.User;

@Singleton
public class UserResource{

	@Inject
	EntityManager em;

	public List<User> getUsers(){
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	public User getUser(UUID id) {
		return em.find(User.class, id);
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public User addUser(User user) {
		if(user.getUserCreation()== null) {
			user.setUserCreation("Daniele");
		}
		if(user.getUserUpdating()==null)
			user.setUserUpdating("Daniele");
		if(user.getTimestampUpdating()==null) {
			user.setTimestampUpdating(LocalDateTime.now());
		}
		if(user.getUserCreation()==null)
			user.setTimestampCreation(LocalDateTime.now());
		em.persist(user);
		return user;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public User updateUser(UUID id, User user) {
		System.out.println("questa è la data e ora "+ LocalDateTime.now().toString());
		
		User userToUpdate = em.find(User.class,id);
		System.out.println(userToUpdate.toString());
		if(userToUpdate != null) {
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setDob(user.getDob());
			if(user.getUserCreation()!=null) {
				userToUpdate.setUserCreation(user.getUserCreation());
			}else {
				userToUpdate.setUserCreation(userToUpdate.getUserCreation());
			}
			
			userToUpdate.setUserUpdating("IO");
			if(user.getUserCreation()!=null) {
			userToUpdate.setTimestampCreation(user.getTimestampCreation());
			}else {
				userToUpdate.setTimestampCreation(userToUpdate.getTimestampCreation());
			}
			userToUpdate.setTimestampUpdating(LocalDateTime.now());
			
			em.persist(userToUpdate);
			

		} else {
			throw new RuntimeException("No such User available");
			
		}
		return userToUpdate;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteUser(UUID id) {
		User user = getUser(id);
		em.remove(user);
	}

}