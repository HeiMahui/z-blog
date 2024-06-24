package zjitc.z.zblogidea.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zjitc.z.zblogidea.pojo.BlogContent;

import java.util.List;

@Mapper
public interface BlogContentDao {

    @Insert("insert into t_blogContent(username, blogTitle, blogContent)values (#{username}, #{blogTitle}, #{blogContent})")
    int insertBlog(BlogContent blogContent);

    @Select("select * from t_blogContent")
    List<BlogContent> selectAllBlog();
    @Select("select blogTitle from t_blogContent")
    List<String> selectAllBlogTitle();
    @Select("select * from t_blogContent where id=#{id};")
    BlogContent selectBlogById(int id);

}
