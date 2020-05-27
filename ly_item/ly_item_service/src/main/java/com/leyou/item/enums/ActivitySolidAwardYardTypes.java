package com.leyou.item.enums;

import java.util.ArrayList;
import java.util.List;

public enum ActivitySolidAwardYardTypes {
    //兑奖码状态 -1.未使用 0.未兑换 1. 已兑换
    LOSE_ONE(-1,"未使用"),
    ZERO(0,"未兑换"),
    ONE(1,"已兑换");

    private Integer type;
    private String message;

    ActivitySolidAwardYardTypes(Integer type, String message) {
        this.type = type;
        this.message = message;
    }
    public Integer getType(){
        return this.type;
    }

    public static List<Integer> getTypes(){
        List<Integer> types = new ArrayList<>();
        for(ActivitySolidAwardYardTypes enabled : ActivitySolidAwardYardTypes.values()){
            types.add(enabled.getType());
        }
        return types;
    }
}
