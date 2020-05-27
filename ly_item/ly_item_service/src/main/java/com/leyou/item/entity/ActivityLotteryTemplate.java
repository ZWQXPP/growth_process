package com.leyou.item.entity;


import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: ActivityLotteryTemplate
 * @Description: 抽奖活动模板
 * @date 2020/3/16 0016
 */
@Data
public class ActivityLotteryTemplate  {

    /**
     * @Fields  : 模板名称
     * @author qiaomengnan
     */ 
    private String name;

    /**
     * @Fields  : 缩略图地址
     * @author qiaomengnan
     */
    private String smallImageUrl;

    /**
     * @Fields  : 预览图地址
     * @author qiaomengnan
     */
    private String imageUrl;

    /**
     * @Fields  : 前端标识
     * @author qiaomengnan
     */
    private String preFlag;

}
