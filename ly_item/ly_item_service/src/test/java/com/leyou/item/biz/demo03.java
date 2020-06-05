package com.leyou.item.biz;

import com.leyou.common.utils.JsonUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class demo03 {

    public static void main(String[] args) {
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
}
