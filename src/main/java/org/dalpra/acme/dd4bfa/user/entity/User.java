package org.dalpra.acme.dd4bfa.user.entity;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.dalpra.acme.dd4bfa.base.entity.EntityBase;


@Entity
@Table(name="users")
public class User extends EntityBase{
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation, String userUpdating,
			String firstName, String lastName, LocalDate dob, String email) {
		
		super(timestampCreation, timestampUpdating, userCreation, userUpdating);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
	}
	
	
	public User() {
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email
				+ ", getId()=" + getId() + ", getTimestampCreation()=" + getTimestampCreation()
				+ ", getTimestampUpdating()=" + getTimestampUpdating() + ", getUserCreation()=" + getUserCreation()
				+ ", getUserUpdating()=" + getUserUpdating() + "]";
	}
	
	
	
}
