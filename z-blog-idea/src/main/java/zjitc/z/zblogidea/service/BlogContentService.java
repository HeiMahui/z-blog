package zjitc.z.zblogidea.service;

import org.springframework.stereotype.Service;
import zjitc.z.zblogidea.pojo.BlogContent;

import java.util.List;

public interface BlogContentService {
    int insertBlog(BlogContent blogContent);

    List<BlogContent> selectAllBlog();
    List<String> selectAllBlogTitle();

    BlogContent selectBlogById(int id);

}
