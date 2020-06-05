package serviceVo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ActivitySolidAwardVo {
    /**
     * @Fields :  实体奖品名称
     */
    private String name;

    /**
     * @Fields :  预发数量
     */
    private Integer preissueNum;

    /**
     * 剩余数量
     */
    private Integer surplusNum;


    /**
     * @Fields : 单品价格
     */
    private BigDecimal price;

    /**
     * @Fields : 图片地址
     */
    private String imageUrls;

    /**
     * @Fields : 奖品类型 1. 实物 2. 游戏 3. 酒店 4. 第三方合作 5.充值卡
     */
    private Integer type;

    /**
     * @Fields : 门店id
     */
    private String branchId;

    /**
     * @Fields : 门店名称
     */
    private String branchName;

    /**
     * @Fields : 视频平台 1. 爱奇艺 2. 腾讯视频 3.优酷会员
     */
    private Integer videoPlatform;
    /**
     * @Fields : 时间类型 1.周卡 2. 月卡 3.年卡
     */
    private Integer typeTime;
    /**
     * @Fields : 兑换码类型 1. 系统兑换码 2. 视频会员兑换码
     */
    private Integer redeemCodeType;
    /**
     * @Fields : 兑换开始时间
     */
    private Date startTime;
    /**
     * @Fields : 兑换结束时间
     */
    private Date endTime;
}
