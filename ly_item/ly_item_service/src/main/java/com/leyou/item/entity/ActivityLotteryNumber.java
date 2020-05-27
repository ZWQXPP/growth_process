package com.leyou.item.entity;


import lombok.Data;

import java.util.Date;

@Data
public class ActivityLotteryNumber {
    // 门店Id
    private String branchId;
    // 证件号
    private String cardId;
    // 活动Id
    private String activityId;
    // 订单Id
    private String orderId;
    // 是否已抽奖
    private Integer used;
    // 有效时间（开始时间）
    private Date startTime;
    // 有效时间（结束时间）
    private Date endTime;

    /**
     * @Fields  : 奖品ID
     * @author qiaomengnan
     */
    private String recordId;

    /**
     * @Fields  : 奖品类型 0.优惠券 1.充值卡 2.实体奖品
     * @author qiaomengnan
     */
    private Integer prizeType;

    /**
     * @Fields  : 中奖时间
     * @author qiaomengnan
     */
    private Date prizeTime;

}
