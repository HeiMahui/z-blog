package zjitc.z.zblogidea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjitc.z.zblogidea.dao.CommentDao;
import zjitc.z.zblogidea.pojo.Comment;
import zjitc.z.zblogidea.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> selectAllCommentById(int id) {
        return commentDao.selectAllCommentById(id);
    }

    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }
}
