package com.example.gittest.controller;

import com.alibaba.fastjson.JSON;
import com.example.gittest.dto.UserDto;
import com.example.gittest.exception.CustomException;
import com.example.gittest.init.UrlInit;
import com.example.gittest.service.IService;
import com.example.gittest.service.MyService;
import com.example.gittest.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController extends BaseController {

    private RedisTemplate<String, Object> redisTemplate;
    private UrlInit urlInit;
    private IService myService;

    @Autowired
    public TestController(RedisTemplate<String, Object> redisTemplate, UrlInit urlInit, IService myService) {
        this.redisTemplate = redisTemplate;
        this.urlInit = urlInit;
        this.myService = myService;
    }

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

    @GetMapping("/service")
    public void getNumbers() {
        myService.doService();
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

    @GetMapping("/init")
    public String init() {
        return urlInit.toString();
    }

    @PostMapping("/userDto")
    public UserDto userDto(@RequestBody UserDto userDto) {
        log.info("/userDto 傳入參數: {}", userDto);
        return userDto;
    }
}
