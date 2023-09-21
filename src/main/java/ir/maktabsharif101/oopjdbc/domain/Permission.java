package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

@SuppressWarnings("unused")
//@Entity
public class Permission extends BaseEntity {

    public static final String TABLE_NAME = "permission_tbl";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
