package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值是 string
     *
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
     * <p>
     * 请求转发是一次请求,不用编写项目名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid 方法执行了");
        //编写请求转发程序 , 手动调不会从控制器走
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向 , 相当于重新发了请求 , 直接发请求 , 不能访问 web-inf , (转发可以)
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 直接会进行响应 , 直接路径发请求 http://localhost:8080/springmvc_day02_01_response_war/testvoid
        response.getWriter().print("你好");

        return;//不想让后面代码执行,return
    }

    /**
     * 返回ModelAndView
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("小凤");
        user.setPassword("456");
        user.setAge(30);

        // 把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user", user);

        // 跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

}
