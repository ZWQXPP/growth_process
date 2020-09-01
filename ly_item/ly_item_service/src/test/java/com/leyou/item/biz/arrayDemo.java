package com.leyou.item.biz;

import com.leyou.common.utils.JsonUtils;

public class arrayDemo {



    public static void main(String[] args) {
        int[] nums = new int[]{61, 23, 4, 74, 13, 148, 20};

        int max = nums[0]; // 假定最大值为数组中的第一个元素
        int min = nums[0]; // 假定最小值为数组中的第一个元素
        double sum = 0;// 累加值
        double avg = 0;// 平均值

        for (int i = 0; i < nums.length; i++) { // 循环遍历数组中的元素
            // 如果当前值大于max，则替换max的值

            if (max < nums[i]) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            // 如果当前值小于min，则替换min的值
            // 累加求和
            sum = sum + nums[i];
        }

        //排序
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        System.out.println("数组排序：" + JsonUtils.toString(nums));
        // 求平均值
        avg = sum / (nums.length);
        System.out.println(JsonUtils.toString(nums));
        System.out.println("数组中的最大值：" + max);
        System.out.println("数组中的最小值：" + min);
        System.out.println("数组中的平均值：" + avg);
    }


    public static void main1(String[] args) {
       /* StringBuffer sb = new StringBuffer();
        sb.append("This is a StringBuffer!");
        sb.append(", =");
        sb.append("This is a StringBuffer!");
        System.out.println(sb.toString());

        StringBuffer sb1 = new StringBuffer("This is a StringBuffer!");
        System.out.println("=================================");
        sb1.delete(0, 5);
       // sb1.deleteCharAt(sb1.length() - 1);
        System.out.println(sb1.toString());*/

        StringBuffer sb = new StringBuffer("This is a StringBuffer!");
        // 能够在指定位置插入字符、字符数组、字符串以及各种数字和布尔值
        sb.insert(2, 'W');
        sb.insert(3, new char[] { 'A', 'B', 'C' });
        sb.insert(8, "abc");
        sb.insert(2, 3);
        sb.insert(3, 2.3f);
        sb.insert(6, 3.75d);
        sb.insert(5, 9843L);
        sb.insert(2, true);
        System.out.println("testInsert: " + sb.toString());
    }
}
