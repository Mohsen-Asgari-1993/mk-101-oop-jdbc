package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;

import java.sql.Connection;
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
