package br.com.eltonsantos.yacht.data.services.map;

import br.com.eltonsantos.yacht.data.model.Task;
import br.com.eltonsantos.yacht.data.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceMap extends AbstractCrudServiceMap<Task, Long> implements TaskService {

}
