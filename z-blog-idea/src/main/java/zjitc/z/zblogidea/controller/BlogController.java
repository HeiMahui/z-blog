package zjitc.z.zblogidea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjitc.z.zblogidea.pojo.BlogContent;
import zjitc.z.zblogidea.service.BlogContentService;


import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogContentService blogContentService;

    @GetMapping("/list")
    public List<BlogContent> titleAll(){
        return blogContentService.selectAllBlog();
    }

    @PostMapping("/create")
    public String createBlog(@RequestBody BlogContent blogContent){
        blogContentService.insertBlog(blogContent);
        return "发布成功";
    }
    
}
