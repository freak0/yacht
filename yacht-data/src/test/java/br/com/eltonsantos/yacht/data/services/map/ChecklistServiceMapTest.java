package br.com.eltonsantos.yacht.data.services.map;

import br.com.eltonsantos.yacht.data.model.Checklist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static java.time.Month.DECEMBER;
import static org.junit.jupiter.api.Assertions.*;

class ChecklistServiceMapTest {

    private static LocalDate XMAS_DATE = LocalDate.of(2018, DECEMBER, 25);

    private ChecklistServiceMap cut;

    @BeforeEach
    void setUp() {
        this.cut = new ChecklistServiceMap();
        this.cut.save(new Checklist(1L, "Create tests", LocalDate.of(2018, DECEMBER, 17)));
        this.cut.save(new Checklist(2L, "Create more tests", LocalDate.of(2018, DECEMBER, 18)));
        this.cut.save(new Checklist(3L, "Create the actual code", LocalDate.of(2018, DECEMBER, 19)));
    }

    @Test
    @DisplayName("When I save a new Checklist, check if its saved using its ID to find it.")
    void save() {
        //when:
        Checklist checklist = new Checklist(4L, "Merry Xmas", XMAS_DATE);
        Checklist returnedChecklist = this.cut.save(checklist);

        //and:
        Optional<Checklist> optChecklistFound = this.cut.findById(4L);

        //then:
        assertTrue(optChecklistFound.isPresent());

        Checklist checklistFound = optChecklistFound.get();

        assertEquals((Object) 4L, checklistFound.getId());
        assertEquals("Merry Xmas", checklistFound.getName());
        assertEquals(XMAS_DATE, checklistFound.getDueDate());
        assertEquals(returnedChecklist, checklistFound);
    }

    @Test
    @DisplayName("Tests the search for all checklists to see if returns only the 3 bootstraped checklists.")
    void findAll() {
        //when:
        Set<Checklist> checklists = this.cut.findAll();

        //then:
        assertEquals(3, checklists.size());
    }

    @Test
    @DisplayName("When I search for a checklist by its ID, check the checklist to see if its data is as expected.")
    void findById() {
        //when:
        Optional<Checklist> optChecklist = this.cut.findById(1L);

        //then:
        assertTrue(optChecklist.isPresent());

        Checklist checklist = optChecklist.get();

        assertEquals((Object) 1L, checklist.getId());
        assertEquals("Create tests", checklist.getName());
        assertEquals(LocalDate.of(2018, DECEMBER, 17), checklist.getDueDate());
    }

    @Test
    @DisplayName("Tests if a deleted checklist is not returned anymore after been excluded based on its id.")
    void deleteById() {
        //when:
        this.cut.deleteById(2L);
        Optional<Checklist> removedChecklist = this.cut.findById(2L);

        //then:
        assertFalse(removedChecklist.isPresent());
    }

    @Test
    @DisplayName("Tests if a deleted checklist is not returned anymore after been excluded.")
    void delete() {
        //when:
        Checklist checklistToBeRemoved = this.cut.findById(3L).get();
        this.cut.delete(checklistToBeRemoved);
        Optional<Checklist> removedChecklist = this.cut.findById(3L);

        //then:
        assertFalse(removedChecklist.isPresent());
    }
}