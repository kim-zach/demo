package com.kimi.demo.controller;

import com.kimi.demo.result.R;
import com.kimi.demo.service.UserService;
import com.kimi.demo.utils.JwtUtils;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@Slf4j
@RestController
@RequestMapping("/aopController")
public class AopController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public R sayHello(String name){
        return R.ok().message("hello");
    }


    @RequestMapping(value = "/weblog", method = RequestMethod.GET)
    public R weblog(String name){
        return R.ok().data("name",name);
    }


    @PostMapping("/login")
    public R login(@PathParam("userName") String userName , @PathParam("password") String password, HttpServletRequest request, HttpServletResponse response){

        String token = JwtUtils.createToken(1l, userName);
        log.info("token :{}" , token);
        return R.ok().data("token",token ) ;
    }






}
