package zjitc.z.zblogidea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjitc.z.zblogidea.dao.UserLoginDao;
import zjitc.z.zblogidea.pojo.User;
import zjitc.z.zblogidea.service.UserLoginService;
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginDao userLoginDao;

    @Override
    public int insertUser(User user) {
        return userLoginDao.insertUser(user);
    }

    @Override
    public User selectByUsername(User user) {
        return userLoginDao.selectByUsername(user.getUsername());
    }
}
