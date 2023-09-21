package ir.maktabsharif101.oopjdbc.domain;

public class Admin extends User {

    private Boolean isSuperAdmin;

    public Boolean getSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }
}
