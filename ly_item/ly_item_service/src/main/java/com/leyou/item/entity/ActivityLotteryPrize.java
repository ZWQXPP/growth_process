package com.leyou.item.entity;


import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: ActivityLotteryPrize
 * @Description: 抽奖活动奖品
 * @date 2020/3/16 0016 
 */
@Data
public class ActivityLotteryPrize  {

    /**
     * @Fields  : 活动ID
     * @author qiaomengnan
     */
    private String activityId;

    /**
     * @Fields  : 奖品ID
     * @author qiaomengnan
     */
    private String prizeId;

    /**
     * @Fields  : 奖品类型 0.优惠券 1.充值卡 2.实体奖品
     * @author qiaomengnan
     */
    private Integer prizeType;

    /**
     * @Fields  : 预发数量(抽奖活动)
     * @author qiaomengnan
     */
    private Integer preissueNum;

    /**
     * @Fields  : 剩余数量(抽奖活动)
     * @author qiaomengnan
     */
    private Integer surplusNum;

}
