package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.service.CommentService;
import ir.maktabsharif101.oopjdbc.service.dto.CommentStatusUpdateDTO;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        CommentService commentService = ApplicationContext.getInstance().getCommentService();

        Set<Long> commentIds = new HashSet<>();
        commentIds.add(12L);
        commentIds.add(14L);
        commentIds.add(16L);
        commentService.updateStatusInBatch(
                new CommentStatusUpdateDTO(
                        commentIds, CommentStatus.ACCEPTED, "reason"
                )
        );
    }
}
