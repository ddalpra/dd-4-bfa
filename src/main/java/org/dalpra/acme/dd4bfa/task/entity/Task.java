package org.dalpra.acme.dd4bfa.task.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dalpra.acme.dd4bfa.base.entity.EntityBase;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="task")
public class Task extends EntityBase{
	
	private String description;

	@OneToMany(mappedBy = "task", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private List<CommentTask> comments = new ArrayList<>();
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CommentTask> getComments() {
		return comments;
	}

	public void setComments(List<CommentTask> comments) {
		this.comments = comments;
	}

	public Task(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating, String description, List<CommentTask> comments) {
		super(timestampCreation, timestampUpdating, userCreation, userUpdating);
		this.description = description;
		this.comments = comments;
	}

	public Task() {
		
	}
	
	
}
