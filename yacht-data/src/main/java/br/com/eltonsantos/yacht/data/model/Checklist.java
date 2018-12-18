package br.com.eltonsantos.yacht.data.model;

import java.time.LocalDate;
import java.util.List;

public class Checklist extends BaseEntity {

    private String name;
    private LocalDate dueDate;
    private String notes;
    private ChecklistGroup group;

    private List<Task> tasks;

    public Checklist() {
    }

    public Checklist(String name, LocalDate dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public ChecklistGroup getGroup() {
        return group;
    }

    public void setGroup(ChecklistGroup group) {
        this.group = group;
    }
}
