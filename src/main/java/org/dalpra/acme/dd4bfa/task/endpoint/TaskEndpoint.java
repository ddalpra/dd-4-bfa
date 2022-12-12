package org.dalpra.acme.dd4bfa.task.endpoint;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.dalpra.acme.dd4bfa.task.entity.CommentTask;
import org.dalpra.acme.dd4bfa.task.entity.Task;
import org.dalpra.acme.dd4bfa.task.resource.CommentTaskResource;
import org.dalpra.acme.dd4bfa.task.resource.TaskResource;

import javax.ws.rs.core.MediaType;


@Path("/api/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskEndpoint {

	@Inject
	TaskResource taskResource;
	
	@Inject
	CommentTaskResource ctResource;
	
	@GET
	public List<Task> list(){
		return taskResource.listAll();
	}
	
	@GET
	@Path("/{id}")
	public Task get(UUID id) {
		return taskResource.findById(id);
	}
	
	@POST
    @Transactional
    public Task create(Task task) {
        taskResource.persist(task);
        return task;
    }
	
	@PUT
    @Path("/{id}")
    @Transactional
    public Task update(UUID id, Task task) {
		Task entity = taskResource.findById(id);
		if(entity == null) {
			throw new NotFoundException();
		}
		entity.setDescription(task.getDescription());
		entity.setTimestampUpdating(LocalDateTime.now());
		taskResource.persist(entity);
		return entity;
	}
	
	@DELETE
    @Path("/{id}")
    @Transactional
    public void delete(UUID id) {
		Task entity = taskResource.findById(id);
		if(entity == null) {
            throw new NotFoundException();
        }
		taskResource.delete(entity);
	}
	
	@POST
	@Path("{id}/comment")
	@Transactional
	public void createComment(@PathParam("id") UUID id, CommentTask commentTask) {
		Task entity = taskResource.findById(id);
		if(entity!=null) {
			commentTask.setTask(entity);
			ctResource.persist(commentTask);
		}
	}
	
	
	
}
