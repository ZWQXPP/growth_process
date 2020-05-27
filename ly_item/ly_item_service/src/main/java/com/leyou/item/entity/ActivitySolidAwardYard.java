package com.leyou.item.entity;


import com.leyou.common.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: ActivitySolidAwardYard
 * @Description: 活动实体类奖品兑换码
 * @date 2020/3/13
 */
@Data
public class ActivitySolidAwardYard extends BaseEntity {

    /**
     * @Fields :  实体奖品ID
     */
    private String activitySolidAwardId;

    /**
     * @Fields :  兑奖码状态  -1.未使用 0.未兑换 1. 已兑换
     */
    private Integer type;

    /**
     * 兑换时间
     */
    private Date exchangeTime;

    /**
     * @Fields : 兑奖码
     */
    private String activitySolidYard;

}
