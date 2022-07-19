package com.example.gittest.controller;

import com.example.gittest.dto.UserDto;
import com.example.gittest.exception.CustomException;
import com.example.gittest.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

    @GetMapping("/redis-test")
    public String redisTest() {
        redisTemplate.opsForValue().set("test", "test");
        return redisTemplate.opsForValue().get("test").toString();
    }

    @GetMapping("/success")
    public ResponseVo success() {
        return getSuccess();
    }

    @GetMapping("/advice")
    public ResponseVo testAdvice() {
        if (true) {
            throw new CustomException(100001, "Custom Exception");
        }
        return getSuccess();
    }

    @GetMapping("/fail")
    public ResponseVo fail() {
        return getFail();
    }
}
