package ir.maktabsharif101.oopjdbc.base.domain;

@SuppressWarnings("unused")
public abstract class BaseEntity {

    private Long id;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
