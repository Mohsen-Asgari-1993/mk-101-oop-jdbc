package ir.maktabsharif101.oopjdbc.service;

import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.service.dto.CommentCreationDTO;
import ir.maktabsharif101.oopjdbc.service.dto.CommentStatusBatchUpdateDTO;
import ir.maktabsharif101.oopjdbc.service.dto.CommentStatusUpdateDTO;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {

    void create(CommentCreationDTO creationDTO) throws SQLException;

    List<Comment> findAllByStatus(CommentStatus status) throws SQLException;

    void updateStatusInBatch(CommentStatusBatchUpdateDTO updateDTO) throws SQLException;

    void updateStatusInBatch(List<CommentStatusUpdateDTO> updateDTOList) throws SQLException;
}
