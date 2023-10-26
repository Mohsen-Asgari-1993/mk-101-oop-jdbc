package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.domain.User;
import ir.maktabsharif101.oopjdbc.repository.UserRepository;

import java.sql.Connection;

@SuppressWarnings("unused")
public class UserRepositoryImpl extends BaseUserRepositoryImpl<User>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected User getNewUserInstance() {
        return new User();
    }

    @Override
    protected String getEntityTableName() {
        return User.TABLE_NAME;
    }

}
