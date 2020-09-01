package com.leyou.item.biz;

import com.leyou.common.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class demo01 {
    @Autowired
    private ActivitySolidAwardYardBiz activitySolidAwardYardBiz;
    @Test
    public void demo01() {
        Random r = new Random();
        int ran1 = r.nextInt(10);
        System.out.println(ran1);

    }

    @Test
    public void demo02() {
        for (int i = 0; i < 5; i++) {
            double max = 10.0;
            double min = 1.0;
            double ran2 = (int) (Math.random() * (max - min) + min);

            System.out.println(ran2);
        }
    }

    @Test
    public void demo03() {
        int max = 100, min = 1;
        long randomNum = System.currentTimeMillis();
        int ran3 = (int) (randomNum % (max - min) + min);
        System.out.println(ran3);
    }


    @Test
    public void demo04() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", i);
            list.add(map);
        }
        System.out.println("list过滤前的数据:" + JsonUtils.toString(list));
        System.out.println("list过滤前的数量:" + list.size());
        //过滤获取 type=2的数据
        List<Map<String, Object>> list2 = list.stream().filter((Map a) -> ("2".equals(a.get("type").toString()))).collect(Collectors.toList());
        //只获取数量也可以这样写
        Long list2Count = list.stream().filter((Map a) -> ("2".equals(a.get("type").toString()))).count();

        System.out.println("list过滤后的数据:" + list2);
        System.out.println("list过滤后的数量:" + list2Count);
        System.out.println("list过滤后的数量:" + list2.size());
    }

}









