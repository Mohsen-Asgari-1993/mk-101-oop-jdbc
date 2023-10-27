package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.base.repository.impl.BaseEntityRepositoryImpl;
import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.repository.CommentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl extends BaseEntityRepositoryImpl<Comment, Long>
        implements CommentRepository {

    public static final String FIND_ALL_BY_STATUS_QUERY_TEMPLATE = "select * from %s where " +
            Comment.STATUS + " = ? order by " + Comment.CREATE_DATE_MILLIS + " desc";

    public CommentRepositoryImpl(Connection connection) {
        super(connection);
        String createTableQuery = "" +
                "CREATE TABLE IF NOT EXISTS mk_101_jdbc." + Comment.TABLE_NAME +
                "(" +
                "    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 )," +
                Comment.TEXT + "    character varying(2048) COLLATE pg_catalog.\"default\" NOT NULL," +
                Comment.WRITER_NAME + "    character varying(255) COLLATE pg_catalog.\"default\" NOT NULL," +
                Comment.NEWS_ID + "    bigint COLLATE pg_catalog.\"default\" ," +
                Comment.CREATE_DATE_MILLIS + "    bigint COLLATE pg_catalog.\"default\" NOT NULL," +
                Comment.STATUS + "    character varying(255) COLLATE pg_catalog.\"default\" NOT NULL," +
                Comment.REASON + "    character varying(2048) COLLATE pg_catalog.\"default\" ," +
                "    CONSTRAINT comment_pkey PRIMARY KEY (id)" +
                ")" +
                "" +
                "TABLESPACE pg_default;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(
                    "ALTER TABLE IF EXISTS mk_101_jdbc." + Comment.TABLE_NAME + " OWNER to postgres;"
            );
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String[] getInsertColumnsForSecondApproach() {
        return new String[]{
                Comment.TEXT,
                Comment.WRITER_NAME,
                Comment.NEWS_ID,
                Comment.CREATE_DATE_MILLIS,
                Comment.STATUS,
                Comment.REASON
        };
    }

    @Override
    protected String getEntityTableName() {
        return Comment.TABLE_NAME;
    }

    @Override
    protected Comment mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Comment comment = new Comment();
        comment.setId(
                resultSet.getLong(1)
        );
        comment.setText(
                resultSet.getString(2)
        );
        comment.setWriterName(
                resultSet.getString(3)
        );
        comment.setNewsId(
                resultSet.getLong(4)
        );
        comment.setCreateDateMillis(
                resultSet.getLong(5)
        );
        comment.setStatus(
                CommentStatus.valueOf(
                        resultSet.getString(6)
                )
        );
        comment.setReason(
                resultSet.getString(7)
        );
        return comment;
    }

    @Override
    protected String getInsertColumnsForFirstApproach() {
        return null;
    }

    @Override
    protected String getInsertValuesForFirstApproach(Comment entity) {
        return null;
    }

    @Override
    protected void fillPreparedStatementParamsForSave(PreparedStatement preparedStatement,
                                                      Comment comment) throws SQLException {
        fillPrepStatementForSaveOrUpdate(preparedStatement, comment);
    }

    @Override
    protected void fillPreparedStatementParamsForUpdate(PreparedStatement preparedStatement,
                                                        Comment comment) throws SQLException {
        fillPrepStatementForSaveOrUpdate(preparedStatement, comment);
        preparedStatement.setLong(7, comment.getId());
    }

    private void fillPrepStatementForSaveOrUpdate(PreparedStatement preparedStatement, Comment comment) throws SQLException {
        preparedStatement.setString(1, comment.getText());
        preparedStatement.setString(2, comment.getWriterName());
        preparedStatement.setLong(3, comment.getNewsId());
        preparedStatement.setLong(4, comment.getCreateDateMillis());
        preparedStatement.setString(5, comment.getStatus().name());
        preparedStatement.setString(6, "");
    }

    @Override
    protected void fillIdParamInPreparedStatement(PreparedStatement preparedStatement,
                                                  int parameterIndex, Long id) throws SQLException {
        preparedStatement.setLong(1, id);
    }

    @Override
    protected void setGenerateKey(Comment entity, ResultSet generatedKeysResultSet) throws SQLException {
        entity.setId(
                generatedKeysResultSet.getLong(1)
        );
    }

    @Override
    public List<Comment> findAllByStatus(CommentStatus status) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        FIND_ALL_BY_STATUS_QUERY_TEMPLATE,
                        Comment.TABLE_NAME
                )
        );
        preparedStatement.setString(1, status.name());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Comment> comments = new ArrayList<>();
        while (resultSet.next()) {
            comments.add(
                    mapResultSetToEntity(resultSet)
            );
        }
        return comments;
    }
}
