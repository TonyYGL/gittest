package com.example.gittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MockTest {

    @MockBean
    private MockService mockService;

    @Test
    public void testMock() {
        Mockito.when(mockService.uncompleted()).thenReturn("uncomplete");
        Assertions.assertEquals("uncomplete", mockService.uncompleted());
    }

}
