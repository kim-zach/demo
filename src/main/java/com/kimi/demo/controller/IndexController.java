package com.kimi.demo.controller;

import com.kimi.demo.entities.User;
import com.kimi.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    private static Logger logger = LogManager.getLogger(IndexController.class.getName());

    @Resource
    private UserService userService;

    @GetMapping("index")//页面的url地址
    public String getindex(Model model)//对应函数
    {
        model.addAttribute("name","bigsai");
        return "index";//与templates中index.html对应
    }

//    /**
//     * 管理员/普通用户登陆
//     *
//     * @param username
//     * @param password
//     * @return
//     */
//    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
//    public ModelAndView login(HttpServletRequest request, String username, String password) {
//        int id;
//        try {
//            id = userService.login(username, password);
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info("not found");
//            return new ModelAndView("login")
//                    .addObject("msg", "Try Again");
//        }
//        User user = userService.selectByPrimaryKey(id);
//        request.getSession().setAttribute("username", user.getName());  // 保存username到session看这里
//        return new ModelAndView(user.getAdmin() == 1 ? "admin" : "home")
//                .addObject("id", user.getId())
//                .addObject("username", user.getName())
//                .addObject("description", user.getDescription())
//                .addObject("isAdmin", user.getAdmin() == 1 ? "admin" : "user");
//    }


}
