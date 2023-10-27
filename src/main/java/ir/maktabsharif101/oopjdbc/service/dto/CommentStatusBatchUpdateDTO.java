package ir.maktabsharif101.oopjdbc.service.dto;

import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;

import java.util.Set;

public class CommentStatusBatchUpdateDTO {

    private Set<Long> commentIds;

    private CommentStatus status;

    private String reason;

    public CommentStatusBatchUpdateDTO() {
    }

    public CommentStatusBatchUpdateDTO(Set<Long> commentIds, CommentStatus status, String reason) {
        this.commentIds = commentIds;
        this.status = status;
        this.reason = reason;
    }

    public Set<Long> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(Set<Long> commentIds) {
        this.commentIds = commentIds;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
