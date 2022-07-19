package com.kimi.demo.controller;

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
    public String sayHello(String name){
        return "hello" + name;
    }


    @RequestMapping(value = "/weblog", method = RequestMethod.GET)
    public String weblog(String name){
        return "hello" + name;
    }


    @PostMapping("/login")
    public void login(@PathParam("userName") String userName , @PathParam("password") String password, HttpServletRequest request, HttpServletResponse response){

        String token = JwtUtils.createToken(1l, userName);
        log.info("token :{}" , token);
    }






}
