package br.com.eltonsantos.yacht.bootstrap;

import br.com.eltonsantos.yacht.data.model.Checklist;
import br.com.eltonsantos.yacht.data.model.ChecklistGroup;
import br.com.eltonsantos.yacht.data.services.ChecklistGroupService;
import br.com.eltonsantos.yacht.data.services.ChecklistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final ChecklistService checklistService;
    private final ChecklistGroupService checklistGroupService;

    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    public DataLoader(ChecklistService checklistService, ChecklistGroupService checklistGroupService) {
        this.checklistService = checklistService;
        this.checklistGroupService = checklistGroupService;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Creating checklist groups...");

        ChecklistGroup australiaChecklistGroup = new ChecklistGroup("Australia travel");
        ChecklistGroup studyListChecklistGroup = new ChecklistGroup("Study list");

        checklistGroupService.save(australiaChecklistGroup);
        checklistGroupService.save(studyListChecklistGroup);

        LOG.info("Checklist groups created.");

        LOG.info("Creating checklists...");

        Checklist luggageChecklist =
                new Checklist("Getting the luggage figured out", LocalDate.of(2018, Month.DECEMBER, 30));
        luggageChecklist.setGroup(australiaChecklistGroup);
        Checklist documentationChecklist =
                new Checklist("Preparing documentation", LocalDate.of(2018, Month.DECEMBER, 22));
        documentationChecklist.setGroup(australiaChecklistGroup);

        Checklist studySpringChecklist =
                new Checklist("Spring studies", LocalDate.of(2019, Month.JANUARY, 7));
        studySpringChecklist.setGroup(studyListChecklistGroup);

        checklistService.save(luggageChecklist);
        checklistService.save(documentationChecklist);
        checklistService.save(studySpringChecklist);

        LOG.info("Checklists created.");
    }

}
