package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.domain.Comment;
import ir.maktabsharif101.oopjdbc.domain.enumeration.CommentStatus;
import ir.maktabsharif101.oopjdbc.service.CommentService;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {

        CommentService commentService = ApplicationContext.getInstance().getCommentService();
//
//        Faker faker = new Faker();
//
//        for (int i = 0; i < 50; i++) {
//            CommentCreationDTO dto = new CommentCreationDTO();
//            dto.setText(
//                    faker.address().fullAddress()
//            );
//            dto.setWriterName(
//                    faker.name().fullName()
//            );
//            dto.setNewsId(
//                    ThreadLocalRandom.current().nextLong(100)
//            );
//            commentService.create(dto);
//        }

        List<Comment> allByStatus = commentService
                .findAllByStatus(CommentStatus.WAITING);
        allByStatus.forEach(System.out::println);


    }
}
