package org.dalpra.acme.dd4bfa.base.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class EntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    
    @Column(name = "TIMESTAMP_CREATION", nullable = false) 
    private LocalDateTime timestampCreation;
    
    @Column(name = "TIMESTAMP_UPDATING", nullable = false) 
    private LocalDateTime timestampUpdating;
    
    @Column(name = "USER_CREATION", nullable = false) 
    private String userCreation;
    
    @Column(name = "USER_UPDATING", nullable = false) 
    private String userUpdating;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public LocalDateTime getTimestampCreation() {
		return timestampCreation;
	}
	public void setTimestampCreation(LocalDateTime timestampCreation) {
		this.timestampCreation = timestampCreation;
	}
	public LocalDateTime getTimestampUpdating() {
		return timestampUpdating;
	}
	public void setTimestampUpdating(LocalDateTime timestampUpdating) {
		this.timestampUpdating = timestampUpdating;
	}
	public String getUserCreation() {
		return userCreation;
	}
	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}
	public String getUserUpdating() {
		return userUpdating;
	}
	public void setUserUpdating(String userUpdating) {
		this.userUpdating = userUpdating;
	}
	
	public EntityBase() {
		
	}
	public EntityBase(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating) {
		
		this.timestampCreation = timestampCreation;
		this.timestampUpdating = timestampUpdating;
		this.userCreation = userCreation;
		this.userUpdating = userUpdating;
	}
	
	@Override
	public String toString() {
		return "EntityBase [id=" + id + ", timestampCreation=" + timestampCreation + ", timestampUpdating="
				+ timestampUpdating + ", userCreation=" + userCreation + ", userUpdating=" + userUpdating + "]";
	}
	
	
	
	
}
