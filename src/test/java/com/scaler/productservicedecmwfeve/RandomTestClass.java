package com.scaler.productservicedecmwfeve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RandomTestClass {
    @Test
    void addOneAndOne(){
       int i=1+1; //act
       assert i==2; //assert
       //assert i==3; //assert
        assertTrue(i==2);
        assertEquals(2,i);
        //assertTimeout(2L,addOneAndTwo());
    }

    @Test
    void addOneAndTwo(){

    }
}
