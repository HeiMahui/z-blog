package zjitc.z.zblogidea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjitc.z.zblogidea.pojo.BlogContent;
import zjitc.z.zblogidea.pojo.Comment;
import zjitc.z.zblogidea.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/all")
    public List<Comment> selectAllBlogComment(@RequestBody BlogContent blogContent){
        System.out.println(blogContent.getId());
        return commentService.selectAllCommentById(blogContent.getId());
    }

    @PostMapping("/write")
    public void insertComment(@RequestBody Comment comment){
        System.out.println(comment);
        commentService.insertComment(comment);
    }



}
