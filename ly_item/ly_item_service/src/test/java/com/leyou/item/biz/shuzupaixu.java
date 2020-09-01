package com.leyou.item.biz;

import java.util.Arrays;

public class shuzupaixu {

    public static void main(String[] args) {
       /* //初始化数组
        int[] array = {63,4,24,1,3,13};
        //排序
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        //输出结果
        System.out.println(Arrays.toString(array));
    }*/
       /* int[] array = {63,4,24,1,3,13};

//排序
        int len = array.length;
//控制轮数
        for (int i = 1; i < len; i++) {
            int max = array[0];
            int index = 0;
            //查找最大值
            for (int j = 1; j < len - (i - 1); j++) {
                if(max < array[j]){
                    max = array[j];
                    index = j;
                }
            }
            //互换位置
            int temp = array[index];
            array[index] = array[len - i];
            array[len - i] = temp;
        }

//输出
        System.out.println(Arrays.toString(array));*/
        //初始化数组
        int[] array = {20,40,90,30,80,70,50};

//排序
        int j;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (j = i - 1; j > 0 && array[j] > temp; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }

//输出
        System.out.println(Arrays.toString(array));
    }
}
