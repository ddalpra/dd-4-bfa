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
		em.persist(user);
		return user;
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void updateUser(UUID id, User user) {
		User userToUpdate = em.find(User.class,id);
		if(userToUpdate != null) {
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setDob(user.getDob());
			userToUpdate.setTimestampCreation(user.getTimestampCreation());
			userToUpdate.setTimestampUpdating(LocalDateTime.now());
			userToUpdate.setUserCreation(user.getUserCreation());
			userToUpdate.setUserUpdating("IO");

			em.persist(userToUpdate);

		} else {
			throw new RuntimeException("No such User available");
		}
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteUser(UUID id) {
		User user = getUser(id);
		em.remove(user);
	}

}