package com.leyou.item.biz;

import com.leyou.common.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class demo03 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            //System.out.println(JsonUtils.toString(list));
        }
        System.out.println(list.get(3));
        System.out.println(JsonUtils.toString(list));
        System.out.println("==========");
// 接近du的数字
        int nearNum = 2;
// 差值实zhi始dao化
        int diffNum = Math.abs(list.get(3) - nearNum);
        System.out.println(diffNum);
// 最终结果
        int result = list.get(0);
        for (Integer integer : list) {
            int diffNumTemp = Math.abs(integer - nearNum);
            if (diffNumTemp < diffNum) {
                diffNum = diffNumTemp;
                result = integer;
            }
        }
        System.out.println(result);
    }
}
