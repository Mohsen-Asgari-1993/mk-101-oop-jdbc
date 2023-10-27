package ir.maktabsharif101.oopjdbc.domain;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Comment extends BaseEntity<Long> {

    public static final String TABLE_NAME = "comment_tbl";

    public static final String TEXT = "text";
    public static final String WRITER_NAME = "writer_name";
    public static final String NEWS_ID = "news_id";
    public static final String CREATE_DATE_MILLIS = "create_date_millis";
    public static final String STATUS = "status";
    public static final String REASON = "reason";

    private String text;

    private String writerName;

    private Long newsId;

    private Long createDateMillis;

    private CommentStatus status;

    private String reason;

    public Comment() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getCreateDateMillis() {
        return createDateMillis;
    }

    public void setCreateDateMillis(Long createDateMillis) {
        this.createDateMillis = createDateMillis;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + getId() + '\'' +
                ", text='" + text + '\'' +
                ", writerName='" + writerName + '\'' +
                ", newsId=" + newsId +
                ", createDate=" + ZonedDateTime.ofInstant(Instant.ofEpochMilli(createDateMillis), ZoneId.systemDefault()) +
                ", status=" + status +
                (StringUtils.isNotBlank(reason) ? ", reason='" + reason + '\'' : "") +
                '}';
    }
}
