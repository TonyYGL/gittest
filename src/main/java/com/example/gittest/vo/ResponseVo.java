package com.example.gittest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseVo {
    private final boolean success;
    private int errorCode;
    private String errorMessage;
}
