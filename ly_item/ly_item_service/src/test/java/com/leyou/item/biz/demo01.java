package com.leyou.item.biz;

import com.leyou.LyItemApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class demo01 {
    @Test
    public void demo01() {
        Random r = new Random(1);
            int ran1 = r.nextInt(10);
            System.out.println(ran1);
    }

    @Test
    public void demo02(){
        for (int i = 0; i < 5; i++) {
            int max=10,min=1;
            int ran2 = (int) (Math.random()*(max-min)+min);
            System.out.println(ran2);
        }
    }
@Test
    public void demo03(){
            int max=100,min=1;
            long randomNum = System.currentTimeMillis();
            int ran3 = (int) (randomNum%(max-min)+min);
            System.out.println(ran3);
        }

}









