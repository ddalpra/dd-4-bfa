package org.dalpra.acme.dd4bfa.task.resource;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import org.dalpra.acme.dd4bfa.task.entity.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class TaskResource implements PanacheRepositoryBase<Task,UUID>{

	public Task findByDesciption(String description	) {
		return find("description",description).firstResult();
	}
	
	
}