package zjitc.z.zblogidea.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjitc.z.zblogidea.pojo.User;
import zjitc.z.zblogidea.service.UserLoginService;
import zjitc.z.zblogidea.service.impl.UserLoginServiceImpl;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user.getUsername() + ", " + user.getPassword());
        User user1 = new User();
        if (userLoginService.selectByUsername(user) != null){
            if (userLoginService.selectByUsername(user).getPassword().equals(user.getPassword())){
                return "登陆成功";
            }else{
                return "密码错误";
            }
        }else if(user.getPassword() =="" || user.getUsername() == ""){
            return "账号密码不能为空";
        }else{
            userLoginService.insertUser(user);
            return "创建成功";
        }

    }
}
