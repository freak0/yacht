package br.com.eltonsantos.yacht.data.services.map;

import br.com.eltonsantos.yacht.data.model.Checklist;
import br.com.eltonsantos.yacht.data.services.ChecklistService;
import org.springframework.stereotype.Service;

@Service
public class ChecklistServiceMap extends AbstractCrudServiceMap<Checklist, Long> implements ChecklistService {

}
