
package com.example.gittest;

import com.alibaba.fastjson2.JSON;
import com.example.gittest.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class RedisTemplateTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    private Map<String, String> multisetMap;
    @BeforeEach
    public void prepareMultisetMap() {
        System.out.println("before ==== ");
        multisetMap = new HashMap<>();
        multisetMap.put("11", "11");
        multisetMap.put("22", "22");
        multisetMap.put("33", "33");
    }

    @Test
    public void testMultiset() {
        redisUtil.multiset(multisetMap);
    }

    @Test
    public void testString() {
        redisUtil.set("test", "would not expire");
        redisUtil.setex("expire", "will expire", 50L);
    }

    @Test
    public void testExpire() {
        redisUtil.expire("test", 15);
    }

    @Test
    public void testObject() {
        UserDto userDto = new UserDto();
        userDto.setCreateDate(new Date());
        userDto.setAge(10);
        userDto.setName("Amy");
        redisTemplate.opsForHash().put("UserDTO", "test", userDto);
        UserDto Amy = (UserDto) redisTemplate.opsForHash().get("UserDTO", "test");
        System.out.println("Amy = " + JSON.toJSONString(Amy));
    }
}
