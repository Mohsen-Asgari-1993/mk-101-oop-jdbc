package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Role;
import ir.maktabsharif101.oopjdbc.repository.RoleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class RoleRepositoryImpl extends BaseEntityRepositoryImpl<Role, Long>
        implements RoleRepository {

    public RoleRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return Role.TABLE_NAME;
    }

    @Override
    protected Role mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getLong(1));
        role.setName(resultSet.getString(2));
//        TODO fill permissions
        return role;
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return Role.NAME;
    }

    @Override
    protected String getInsertValuesForFirstApproach(Role entity) {
        return "'".concat((entity).getName()).concat("'");
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                Role.NAME
        };
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                      Role entity) throws SQLException {
//        inset into role_tbl(name) values(?)
        preparedStatement.setString(
                1,
                (entity).getName()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement,
                                                        Role entity) throws SQLException {
        preparedStatement.setString(
                1,
                (entity).getName()
        );
        preparedStatement.setLong(
                2,
                entity.getId()
        );
    }

    @Override
    protected void fillIdParamInPreparedStatement(PreparedStatement preparedStatement, int parameterIndex, Long id) throws SQLException {
        preparedStatement.setLong(
                parameterIndex, id
        );
    }

    @Override
    protected void setGenerateKey(Role entity, ResultSet generatedKeysResultSet) throws SQLException {
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
    }
}
