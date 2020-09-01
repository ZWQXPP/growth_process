package com.leyou.item.biz;

import com.leyou.common.utils.JsonUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class demo03 {

    public static void main(String[] args) {
        String beginTime = "2018-07-30 14:42:32";
        String endTime = "2018-07-29 12:26:32";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date1 = format.parse(beginTime);
            Date date2 = format.parse(endTime);

            boolean before = date2.before(date1);

            System.out.println(before);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main9(String[] args) {


        BigDecimal a = new BigDecimal(111);
        BigDecimal b = new BigDecimal(111.5);

        /*Integer a = 2;
        Integer b = 3;*/
      /*  String a = "4";
        String b ="3";*/

        //使用 compare To方法比较
        //注意：a、b均不能为null，否则会报空指针
        if (a.compareTo(b) == -1) {
            System.out.println("a小于b");
        }

        if (a.compareTo(b) == 0) {
            System.out.println("a等于b");
        }

        if (a.compareTo(b) == 1) {
            System.out.println("a大于b");
        }

        if (a.compareTo(b) > -1) {
            System.out.println("a大于等于b");
        }

        if (a.compareTo(b) < 1) {
            System.out.println("a小于等于b");
        }
    }


    public static void main7(String[] args) {
        //创建map集合
        //Map<String,String> map = new HashMap<String,String>();
        //Map<String,String> map = new LinkedHashMap<String,String>();
        Map<String, String> map = new TreeMap<String, String>();
        //往map集合添加 key  和 value
        map.put("cn", "Chinese");
        map.put("us", "America");
        map.put("en", "England");
        map.put("jp", "Japan");
        map.put("us", "the united stas");
        map.put("uk", "Japan");
        map.put("cs", "cs");

        //通过key 找到value
        String value = map.get("us");//key不是下标，是键  不仅仅代码少，使用简单 速度也快
        System.out.println("========");
        System.out.println(value);  //输出cs的value值
        System.out.println("========");
        //输出
        System.out.println(map.size()+1);   //输出map集合的大小
        System.out.println(map.keySet());  //输出所有的key值
        System.out.println(map.values());  //输出所有的value值
        System.out.println("输出所有的键值对  " + JsonUtils.toString(map) );   //输出所有的键值对。
        System.out.println(map.entrySet());  //输出所有的键值对。
    }
}
