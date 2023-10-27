package ir.maktabsharif101.oopjdbc.service.dto;

public class CommentCreationDTO {

    private String text;

    private String writerName;

    private Long newsId;

    public CommentCreationDTO() {
    }

    public CommentCreationDTO(String text, String writerName, Long newsId) {
        this.text = text;
        this.writerName = writerName;
        this.newsId = newsId;
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
}
