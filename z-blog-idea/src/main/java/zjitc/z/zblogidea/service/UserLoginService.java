package zjitc.z.zblogidea.service;

import zjitc.z.zblogidea.pojo.User;

public interface UserLoginService {
    int insertUser(User user);

    User selectByUsername(User user);
}
