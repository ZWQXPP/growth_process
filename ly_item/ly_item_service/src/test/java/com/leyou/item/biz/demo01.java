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
        int ran1 =0;
        for (int i1 = 0; i1<=10; i1++) {
            int ran2 = r.nextInt(16);
            for (int i = 0; i <= 6; i++) {
                 ran1 = r.nextInt(36);
                System.out.print(ran1 + ", ");
            }

            System.out.println(ran1 + ", "+"蓝" + ran2);

        }

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

    @Test
    public void demo05(){
        Map<String, String> map = new HashMap<>();
        map.put("1","1新东方国际性");
        map.put("2返还给地方1","2");
        map.put("3分析对方","3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " ：" + entry.getValue());
        }
        System.out.println("=================");
        System.out.println(map.get(1));
        System.out.println(map.values());
        System.out.println(map.keySet());
        System.out.println("=================");
        System.out.println(map.entrySet());
        System.out.println("=================");
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void mapDemo01(){
        Map<Integer, String> ma = new HashMap<Integer, String>();
        //给集合中存入元素
        ma.put(1, "abc01");  //这里将基本数据类型自动装箱
        ma.put(2, "abc02");
        ma.put(3, "abc03");
        ma.put(4, "abc04");

        //将Map集合当中的映射关系取出，存入到Set集合当中
        Set< Map.Entry<Integer, String> > entryset = ma.entrySet();
        System.out.print(entryset);
        System.out.println("=========================");

        for (Map.Entry<Integer, String> entry : entryset) {
            System.out.println(entry);
        }

        System.out.println("============4444=============");
        //取迭代器
        Iterator< Map.Entry<Integer, String> > it = entryset.iterator();


        for(Map.Entry en:entryset)
        {
            System.out.println("1:"+en);
            System.out.println("2:"+en.getKey());
            System.out.println("3:"+en.getValue());
            System.out.println("======ffff======");
        }
        System.out.println("==========555555555===============");
        //获取Map集合中的元素
        while( it.hasNext() ) {
            Map.Entry<Integer, String> en = it.next();
            Integer maKey = en.getKey();
            String maValue = en.getValue();

            System.out.println( maKey + " : " + maValue );
        }
    }

}









