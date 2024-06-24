package zjitc.z.zblogidea.service;

import org.springframework.beans.factory.annotation.Autowired;
import zjitc.z.zblogidea.pojo.Comment;

import java.util.List;

public interface CommentService {


    List<Comment> selectAllCommentById(int id);


    void insertComment(Comment comment);
}
