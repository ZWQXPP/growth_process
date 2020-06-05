package com.leyou.item.biz;

import com.leyou.common.utils.JsonUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class demo03 {

    public static void main1(String[] args) {
        String beginTime = "2018-07-30 14:42:32";
        String endTime = "2018-07-29 12:26:32";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date1 = format.parse(beginTime);
            Date date2 = format.parse(endTime);

            boolean before = date1.before(date2);

            System.out.println(before);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        BigDecimal a = new BigDecimal(121);
        BigDecimal b = new BigDecimal(111);

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
}
