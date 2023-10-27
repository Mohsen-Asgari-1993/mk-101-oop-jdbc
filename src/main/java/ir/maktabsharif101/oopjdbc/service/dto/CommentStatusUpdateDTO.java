package ir.maktabsharif101.oopjdbc.service.dto;

import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;

public class CommentStatusUpdateDTO {

    private Long commentId;

    private CommentStatus status;

    private String reason;

    public CommentStatusUpdateDTO() {
    }

    public CommentStatusUpdateDTO(Long commentId, CommentStatus status, String reason) {
        this.commentId = commentId;
        this.status = status;
        this.reason = reason;
    }

    public Long getCommentId() {
        return commentId;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
