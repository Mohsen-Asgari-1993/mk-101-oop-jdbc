package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.service.CommentService;
import ir.maktabsharif101.oopjdbc.service.dto.CommentStatusUpdateDTO;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        CommentService commentService = ApplicationContext.getInstance().getCommentService();
        List<Comment> waiting = commentService.findAllByStatus(CommentStatus.WAITING);
        waiting.forEach(System.out::println);

        List<CommentStatusUpdateDTO> updateDTOList = new ArrayList<>();
        updateDTOList.add(
                new CommentStatusUpdateDTO(
                        17L,
                        CommentStatus.ACCEPTED,
                        null
                )
        );
        updateDTOList.add(
                new CommentStatusUpdateDTO(
                        21L,
                        CommentStatus.REJECTED,
                        "21 reason"
                )
        );
        updateDTOList.add(
                new CommentStatusUpdateDTO(
                        25L,
                        CommentStatus.ACCEPTED,
                        ""
                )
        );
        updateDTOList.add(
                new CommentStatusUpdateDTO(
                        29L,
                        CommentStatus.ACCEPTED,
                        ""
                )
        );
        updateDTOList.add(
                new CommentStatusUpdateDTO(
                        34L,
                        CommentStatus.REJECTED,
                        "34 reason"
                )
        );
        commentService.updateStatusInBatch(updateDTOList);

    }
}
