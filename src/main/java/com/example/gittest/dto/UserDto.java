package com.example.gittest.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    @JSONField(name = "Username")
    private String name;
    private int age;
    @JSONField(name = "CreateDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
}
