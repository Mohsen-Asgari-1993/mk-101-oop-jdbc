package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.repository.CommentRepository;
import ir.maktabsharif101.oopjdbc.service.CommentService;
import ir.maktabsharif101.oopjdbc.service.dto.CommentCreationDTO;
import ir.maktabsharif101.oopjdbc.service.dto.CommentStatusBatchUpdateDTO;
import ir.maktabsharif101.oopjdbc.service.dto.CommentStatusUpdateDTO;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
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
    public void updateStatusInBatch(CommentStatusBatchUpdateDTO updateDTO) throws SQLException {
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

//        List<Comment> selectedComments =
//                baseRepository.findAll()
//                        .stream().filter(comment -> updateDTO.getCommentIds().contains(comment.getId()))
//                        .collect(Collectors.toList());
        List<Comment> selectedComments = baseRepository.findAllByIdIn(
                updateDTO.getCommentIds()
        );
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

    @Override
    public void updateStatusInBatch(List<CommentStatusUpdateDTO> updateDTOList) throws SQLException {
        if (updateDTOList == null || updateDTOList.isEmpty()) {
            throw new RuntimeException("empty commentIds");
        }

        /*if (updateDTOList.stream().anyMatch(dto -> dto.getCommentId() == null)) {
            throw new RuntimeException("empty commentId");
        }
        if (updateDTOList.stream().anyMatch(dto -> dto.getStatus() == null)) {
            throw new RuntimeException("empty status");
        }
        if (updateDTOList.stream().anyMatch(dto -> CommentStatus.REJECTED.equals(dto.getStatus()) && StringUtils.isBlank(dto.getReason()))) {
            throw new RuntimeException("empty reason");
        }*/
        if (
                updateDTOList.stream()
                        .anyMatch(
                                dto -> dto.getCommentId() == null || dto.getStatus() == null ||
                                        CommentStatus.WAITING.equals(dto.getStatus()) ||
                                        CommentStatus.REJECTED.equals(dto.getStatus()) && StringUtils.isBlank(dto.getReason())
                        )
        ) {
            throw new RuntimeException("invalid input");
        }

        /*if (
                updateDTOList.stream()
                        .allMatch(
                                dto -> dto.getCommentId() != null && dto.getStatus() != null &&
                                        (!CommentStatus.REJECTED.equals(dto.getStatus()) || StringUtils.isNotBlank(dto.getReason()))
                        )
        ) {

        } else {
            throw new RuntimeException("invalid input");
        }*/


        Set<Long> commentIds = updateDTOList.stream().map(CommentStatusUpdateDTO::getCommentId)
                .collect(Collectors.toSet());
//        db comments
        List<Comment> selectedComments = baseRepository.findAllByIdIn(commentIds);
        if (selectedComments.isEmpty() || selectedComments.size() != commentIds.size()) {
            throw new RuntimeException("wrong ids");
        }

        selectedComments.forEach(comment ->
                updateDTOList.stream().filter(dto -> comment.getId().equals(dto.getCommentId()))
                        .findFirst().ifPresent(dto -> {

                            CommentStatus currentStatus = comment.getStatus();

                            CommentStatus newStatus = dto.getStatus();

                            if (CommentStatus.WAITING.equals(currentStatus)) {

                                comment.setStatus(newStatus);
                                if (CommentStatus.REJECTED.equals(newStatus)) {
                                    comment.setReason(dto.getReason());
                                }

                            } else if (CommentStatus.ACCEPTED.equals(currentStatus)) {

                                if (CommentStatus.REJECTED.equals(newStatus)) {
                                    comment.setStatus(newStatus);
                                    comment.setReason(dto.getReason());
                                } else {
                                    throw new RuntimeException("invalid status for comment with id : " + comment.getId());
                                }

                            } else {

                                if (CommentStatus.ACCEPTED.equals(newStatus)) {
                                    comment.setStatus(newStatus);
                                } else {
                                    throw new RuntimeException("invalid status");
                                }

                            }
                            try {
                                baseRepository.update(comment);
                            } catch (SQLException ignore) {
                            }

                        }));
    }
}
