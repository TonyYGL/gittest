package com.example.gittest.controller;

import com.example.gittest.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String testController() {
        return "hello";
    }

    @GetMapping("/user")
    public UserDto getUser() {
        UserDto userDto = new UserDto();
        userDto.setAge(1);
        userDto.setName("Amy");
        userDto.setCreateDate(new Date());
        return userDto;
    }

}
