package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

import java.util.List;

@SuppressWarnings("unused")
//@Entity
public class Role extends BaseEntity<Long> {

    public static final String TABLE_NAME = "role_tbl";
    public static final String NAME = "name";

    private String name;

    //    ManyToMany
    private List<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
