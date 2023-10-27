package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.repository.CommentRepository;
import ir.maktabsharif101.oopjdbc.service.CommentService;
import ir.maktabsharif101.oopjdbc.service.dto.CommentCreationDTO;
import ir.maktabsharif101.oopjdbc.service.dto.CommentStatusUpdateDTO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void updateStatusInBatch(CommentStatusUpdateDTO updateDTO) throws SQLException {
        if (updateDTO.getCommentIds() == null || updateDTO.getCommentIds().isEmpty()) {
            throw new RuntimeException("empty commentIds");
        }
        if (updateDTO.getStatus() == null) {
            throw new RuntimeException("empty status");
        }
        if (CommentStatus.REJECTED.equals(updateDTO.getStatus()) &&
                StringUtils.isBlank(updateDTO.getReason())) {
            throw new RuntimeException("empty reason for rejected");
        }
//        updateDTO.commentIds[1, 2, 3, 4, 500]
//        selectedComments[1, 2, 3, 4]

        List<Comment> selectedComments =
                baseRepository.findAll()
                        .stream().filter(comment -> updateDTO.getCommentIds().contains(comment.getId()))
                        .collect(Collectors.toList());
        if (selectedComments.isEmpty() || selectedComments.size() != updateDTO.getCommentIds().size()) {
            throw new RuntimeException("wrong ids");
        }

        selectedComments.forEach(comment -> {
            comment.setStatus(updateDTO.getStatus());
            if (CommentStatus.REJECTED.equals(updateDTO.getStatus())) {
                comment.setReason(updateDTO.getReason());
            }
            try {
                baseRepository.update(comment);
            } catch (SQLException ignore) {
            }
        });

    }
}
