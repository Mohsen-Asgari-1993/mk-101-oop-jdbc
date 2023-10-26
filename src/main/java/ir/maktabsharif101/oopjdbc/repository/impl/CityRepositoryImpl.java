package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.City;
import ir.maktabsharif101.oopjdbc.repository.CityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepositoryImpl extends BaseEntityRepositoryImpl<City, Long>
        implements CityRepository {

    public CityRepositoryImpl(Connection connection) {
        super(connection);
        String createTableQuery = "" +
                "CREATE TABLE IF NOT EXISTS mk_101_jdbc." + City.TABLE_NAME +
                "(" +
                "    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 )," +
                City.NAME + "    character varying(255) COLLATE pg_catalog.\"default\" NOT NULL," +
                "    CONSTRAINT city_pkey PRIMARY KEY (id)" +
                ")" +
                "" +
                "TABLESPACE pg_default;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(
                    "ALTER TABLE IF EXISTS mk_101_jdbc.city OWNER to postgres;"
            );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                City.NAME
        };
    }

    @Override
    protected String getEntityTableName() {
        return City.TABLE_NAME;
    }

    @Override
    protected City mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new City(
                resultSet.getLong(1),
                resultSet.getString(2)
        );
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return City.NAME;
    }

    @Override
    protected String getInsertValuesForFirstApproach(City entity) {
        return entity.getName();
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                      City entity) throws SQLException {
        preparedStatement.setString(
                1, entity.getName()
        );

    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement, City entity)
            throws SQLException {
        preparedStatement.setString(
                1, entity.getName()
        );
        preparedStatement.setLong(
                2, entity.getId()
        );
    }

    @Override
    protected void fillIdParamInPreparedStatement(PreparedStatement preparedStatement, int parameterIndex, Long id) throws SQLException {
        preparedStatement.setLong(
                parameterIndex, id
        );
    }

    @Override
    protected void setGenerateKey(City entity, ResultSet generatedKeysResultSet) throws SQLException {
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
    }


}
