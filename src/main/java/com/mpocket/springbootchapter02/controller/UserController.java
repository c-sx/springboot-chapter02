package com.mpocket.springbootchapter02.controller;

import com.mpocket.springbootchapter02.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


/**
 * UserController 是一个基于注解的控制器
 * 可以同时处理多个请求动作
 */
@Controller
public class UserController {

    /**
     * RequestMapping 用来映射一个请求和请求的方法
     * value="/register" 表示请求由 register 方法进行处理
     *
     * @return
     */
    @RequestMapping(value = "/register")
    public ModelAndView Register(@Valid User user, BindingResult bindingResult) {
        // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        // 在 model 中添加一个名为 "user" 的 user 对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            modelAndView.setViewName("success");
        }
        return modelAndView;
//        model.addAttribute("user", user);
        // 返回一个字符串 " success" 作为视图名称
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
