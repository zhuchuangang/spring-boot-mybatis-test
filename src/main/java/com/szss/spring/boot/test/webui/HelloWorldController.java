package com.szss.spring.boot.test.webui;

import com.szss.spring.boot.test.entity.User;
import com.szss.spring.boot.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zcg on 15/12/24.
 */

@Controller
public class HelloWorldController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/helloworld")
    public String helloWorld(@RequestParam("id") Long id, Model model) {
        User user = userMapper.getUserById(id);
        model.addAttribute("user", user);
        return "/helloworld";
    }

    @GetMapping("/test")
    @ResponseBody
    public User test() {
        User user = new User();
        user.setId(100L);
        user.setUsername("test");
        return user;
    }
}
