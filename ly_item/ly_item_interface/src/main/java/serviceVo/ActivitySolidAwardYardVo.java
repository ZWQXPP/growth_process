package serviceVo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: ActivitySolidAwardYard
 * @Description: 活动实体类奖品兑换码
 * @date 2020/3/13
 */
@Data
public class ActivitySolidAwardYardVo {

    /**
     * @Fields  : ID
     * @author qiaomengnan
     */
    private String id;

   /**
     * @Fields  :  实体奖品ID
     */
    private String activitySolidAwardId;

    /**
     * @Fields  :  兑奖码状态 0. 未使用 1. 已使用
     */
    private Integer type;

    /**
     * @Fields  : 兑奖码
     */
    private String activitySolidYard;

    /**
     * @Fields  : 随机
     * @author qiaomengnan
     */
    private Integer rand;

    /**
     * @Fields : 奖品名称
     * @author fengdefa
     */
    private String name;

    /**
     * @Fields  : 奖品价格
     * @author qiaomengnan
     */
    private BigDecimal price;

    private String branchId;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Boolean deleted;

}
