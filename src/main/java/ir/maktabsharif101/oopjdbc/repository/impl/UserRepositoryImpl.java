package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class UserRepositoryImpl extends BaseEntityRepositoryImpl
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
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
    protected BaseEntity[] getBaseEntityArrayForFindAll() throws SQLException {
        return new User[(int) count()];
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return User.FIRST_NAME.concat(", ").concat(User.LAST_NAME).concat(", ").concat(User.USERNAME)
                .concat(", ").concat(User.PASSWORD);
//        return User.FIRST_NAME + ", " + User.LAST_NAME + ", " + User.USERNAME + ", " + User.PASSWORD;
    }

    @Override
    protected String getInsertValuesForFirstApproach(BaseEntity entity) {
        User user = (User) entity;
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
                                                      BaseEntity entity) throws SQLException {
//        inset into user_tbl(first_name, last_name, username, password) values(?, ?, ?, ?)
        User user = (User) entity;
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
                                                        BaseEntity entity) throws SQLException {
        User user = (User) entity;
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
