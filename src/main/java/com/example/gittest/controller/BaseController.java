package com.example.gittest.controller;

import com.example.gittest.vo.ResponseVo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public ResponseVo getSuccess() {
        return new ResponseVo(true);
    }

    public ResponseVo getFail() {
        return new ResponseVo(false);
    }
}
