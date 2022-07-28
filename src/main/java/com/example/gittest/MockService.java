package com.example.gittest;

import org.springframework.stereotype.Service;

@Service
public class MockService {

    public String uncompleted() {
        System.out.println("MockService.uncompleted()");
        throw new UnsupportedOperationException();
    }
}
