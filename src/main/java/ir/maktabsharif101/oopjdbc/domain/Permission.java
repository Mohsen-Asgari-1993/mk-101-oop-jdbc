package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

@SuppressWarnings("unused")
//@Entity
public class Permission extends BaseEntity<Long> {

    public static final String TABLE_NAME = "permission_tbl";

    public static final String NAME = "name";

    //    @Column(NAME)
    private String name;

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }

    public Permission(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
