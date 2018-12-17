package br.com.eltonsantos.yacht.data.services.map;

import br.com.eltonsantos.yacht.data.model.ChecklistGroup;
import br.com.eltonsantos.yacht.data.services.ChecklistGroupService;

public class ChecklistGroupServiceMap extends AbstractCrudServiceMap<ChecklistGroup, Long> implements ChecklistGroupService {

    @Override
    public ChecklistGroup save(ChecklistGroup checklistGroup) {
        return super.save(checklistGroup.getId(), checklistGroup);
    }

}
