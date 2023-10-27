package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;

import java.sql.SQLException;
import java.util.List;

public interface CommentRepository extends BaseEntityRepository<Comment, Long> {

    List<Comment> findAllByStatus(CommentStatus status) throws SQLException;
}
