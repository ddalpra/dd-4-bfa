package org.dalpra.acme.dd4bfa.task.resource;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import org.dalpra.acme.dd4bfa.task.entity.CommentTask;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class CommentTaskResource  implements PanacheRepositoryBase<CommentTask,UUID>{
	
}
