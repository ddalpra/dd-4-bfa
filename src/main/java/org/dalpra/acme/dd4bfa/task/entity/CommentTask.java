package org.dalpra.acme.dd4bfa.task.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.dalpra.acme.dd4bfa.base.entity.EntityBase;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="comment")
public class CommentTask extends EntityBase{
	
	private String comment;

    @ManyToOne
    @JoinColumn(name ="fk_task")
    @JsonBackReference
    private Task task;    

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public CommentTask(LocalDateTime timestampCreation, LocalDateTime timestampUpdating, String userCreation,
			String userUpdating, String comment, Task task) {
		super(timestampCreation, timestampUpdating, userCreation, userUpdating);
		this.comment = comment;
		this.task = task;
	}

	public CommentTask() {
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
