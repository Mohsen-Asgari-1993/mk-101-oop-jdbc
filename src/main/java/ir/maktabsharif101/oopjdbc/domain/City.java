package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

@SuppressWarnings("unused")
public class City extends BaseEntity<Long> {

    public static final String TABLE_NAME = "city_tbl";

    public static final String NAME = "name";

    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public City(Long id, String name) {
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
        return "City{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
