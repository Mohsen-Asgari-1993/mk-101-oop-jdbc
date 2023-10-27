package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.repository.CommentRepository;
import ir.maktabsharif101.oopjdbc.service.CommentService;
import ir.maktabsharif101.oopjdbc.service.dto.CommentCreationDTO;

import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    private final CommentRepository baseRepository;

    public CommentServiceImpl(CommentRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public void create(CommentCreationDTO creationDTO) throws SQLException {
//  TODO validate newsId
        Comment comment = new Comment();
        comment.setText(creationDTO.getText());
        comment.setWriterName(creationDTO.getWriterName());
        comment.setNewsId(creationDTO.getNewsId());
        comment.setCreateDateMillis(
                ZonedDateTime.now().toInstant().toEpochMilli()
        );
        comment.setStatus(
                CommentStatus.WAITING
        );
        baseRepository.save(comment);
    }

    @Override
    public List<Comment> findAllByStatus(CommentStatus status) throws SQLException {
        if (status == null) {
            return baseRepository.findAll();
        } else {
            return baseRepository.findAllByStatus(status);
        }
    }

//    void updateStatusInBatch();
}
