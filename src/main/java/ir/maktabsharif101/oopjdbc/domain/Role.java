package ir.maktabsharif101.oopjdbc.domain;

@SuppressWarnings("unused")
//@Entity
public class Role {

    private Long id;

    private String name;

    //    ManyToMany
    private Permission[] permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission[] getPermissions() {
        return permissions;
    }

    public void setPermissions(Permission[] permissions) {
        this.permissions = permissions;
    }
}
