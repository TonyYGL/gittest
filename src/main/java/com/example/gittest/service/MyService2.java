package com.example.gittest.service;

import org.springframework.stereotype.Service;

@Service
public class MyService2 implements IService{
    @Override
    public void doService() {
        System.out.println(this.getClass().getName());
    }
}
