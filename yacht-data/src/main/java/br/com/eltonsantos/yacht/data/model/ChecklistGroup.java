package br.com.eltonsantos.yacht.data.model;

public class ChecklistGroup extends BaseEntity {

    private String name;

    public ChecklistGroup() {
    }

    public ChecklistGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
