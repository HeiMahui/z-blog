package zjitc.z.zblogidea.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zjitc.z.zblogidea.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentDao {

    @Select("select * from t_comment where bId=#{id}")
    List<Comment> selectAllCommentById(int id);
    @Insert("insert into t_comment(bId, username, commentContent)values (#{bId}, #{username}, #{commentContent})")
    void insertComment(Comment comment);
}
