package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.Entity;

@SuppressWarnings("unused")
//@Entity
public class Permission extends Entity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
