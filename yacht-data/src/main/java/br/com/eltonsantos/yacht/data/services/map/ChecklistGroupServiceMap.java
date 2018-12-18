package br.com.eltonsantos.yacht.data.services.map;

import br.com.eltonsantos.yacht.data.model.ChecklistGroup;
import br.com.eltonsantos.yacht.data.services.ChecklistGroupService;
import org.springframework.stereotype.Service;

@Service
public class ChecklistGroupServiceMap extends AbstractCrudServiceMap<ChecklistGroup, Long> implements ChecklistGroupService {

}
