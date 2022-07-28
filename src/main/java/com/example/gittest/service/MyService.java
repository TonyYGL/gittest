package com.example.gittest.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MyService implements IService {

    private List<Integer> numbers = Arrays.asList(1,2,3);

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public void doService() {
        System.out.println(this.getClass().getName());
    }
}
