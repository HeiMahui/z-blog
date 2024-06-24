package zjitc.z.zblogidea.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import zjitc.z.zblogidea.pojo.User;

import java.util.List;

@Mapper
public interface UserLoginDao {

    @Insert("insert  into t_user(username, password)values (#{username}, #{password})")
    int insertUser(User user);



    @Select("select * from t_user where username=#{username}")
    User selectByUsername(String username);


}
