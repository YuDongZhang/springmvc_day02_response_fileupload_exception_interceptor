package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值是 string
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString 方法执行了");
        //模拟从数据库中查询 user 对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(12);
        //model对象 , 存到 request 转发到页面 success
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 默认是找 testVoid jsp
     * 返回值是void
     * @param model
     */
    @RequestMapping("/testVoid")
    public void testVoid(Model model) {
        System.out.println("testVoid 方法执行了");

    }
}
