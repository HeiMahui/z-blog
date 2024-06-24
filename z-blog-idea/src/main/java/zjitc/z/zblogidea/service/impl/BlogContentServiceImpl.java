package zjitc.z.zblogidea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjitc.z.zblogidea.dao.BlogContentDao;
import zjitc.z.zblogidea.pojo.BlogContent;
import zjitc.z.zblogidea.service.BlogContentService;

import java.util.List;
@Service
public class BlogContentServiceImpl implements BlogContentService {
    @Autowired
    private BlogContentDao blogContentDao;
    @Override
    public int insertBlog(BlogContent blogContent) {
        return blogContentDao.insertBlog(blogContent);
    }

    @Override
    public List<BlogContent> selectAllBlog() {
        return blogContentDao.selectAllBlog();
    }

    @Override
    public List<String> selectAllBlogTitle() {
        return blogContentDao.selectAllBlogTitle();
    }

    @Override
    public BlogContent selectBlogById(int id) {
        return blogContentDao.selectBlogById(id);
    }
}
