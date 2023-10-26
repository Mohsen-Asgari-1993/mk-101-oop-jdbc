package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(
                resultSet.getLong(1)
        );
        user.setFirstName(
                resultSet.getString(2)
        );
        user.setLastName(
                resultSet.getString(3)
        );
        user.setUsername(
                resultSet.getString(4)
        );
        user.setPassword(
                resultSet.getString(5)
        );
//        TODO fill roles
        return user;
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return User.FIRST_NAME.concat(", ").concat(User.LAST_NAME).concat(", ").concat(User.USERNAME)
                .concat(", ").concat(User.PASSWORD);
//        return User.FIRST_NAME + ", " + User.LAST_NAME + ", " + User.USERNAME + ", " + User.PASSWORD;
    }

    @Override
    protected String getInsertValuesForFirstApproach(User user) {
        return "'".concat(user.getFirstName()).concat("', ").
                concat("'").concat(user.getLastName()).concat("', ").
                concat("'").concat(user.getUsername()).concat("', ").
                concat("'").concat(user.getPassword()).concat("'");
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                User.FIRST_NAME,
                User.LAST_NAME,
                User.USERNAME,
                User.PASSWORD
        };
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                      User user) throws SQLException {
//        inset into user_tbl(first_name, last_name, username, password) values(?, ?, ?, ?)
        preparedStatement.setString(
                1,
                user.getFirstName()
        );
        preparedStatement.setString(
                2,
                user.getLastName()
        );
        preparedStatement.setString(
                3,
                user.getUsername()
        );
        preparedStatement.setString(
                4,
                user.getPassword()
        );
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement,
                                                        User user) throws SQLException {
        preparedStatement.setString(
                1,
                user.getFirstName()
        );
        preparedStatement.setString(
                2,
                user.getLastName()
        );
        preparedStatement.setString(
                3,
                user.getUsername()
        );
        preparedStatement.setString(
                4,
                user.getPassword()
        );
        preparedStatement.setLong(
                5,
                user.getId()
        );
    }

    @Override
    protected void fillIdParamInPreparedStatement(PreparedStatement preparedStatement, int parameterIndex, Long id) throws SQLException {
        preparedStatement.setLong(
                parameterIndex, id
        );
    }

    @Override
    protected void setGenerateKey(User entity, ResultSet generatedKeysResultSet) throws SQLException {
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return false;
    }
}
