package com.leyou.item.biz;

import com.leyou.common.exception.ServiceException;
import com.leyou.common.utils.StringUtils;
import com.leyou.common.utils.UUIDUtils;
import com.leyou.item.entity.ActivitySolidAward;
import com.leyou.item.mapper.ActivitySolidAwardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Transactional(rollbackFor = Exception.class)
public class ActivitySolidAwardBiz  {
    @Autowired
    private ActivitySolidAwardMapper activitySolidAwardMapper;

    public ActivitySolidAward findAward(String id) {
        return this.activitySolidAwardMapper.selectAward(id);
    }

    /**
     * @Description: 奖品添加
     * @auther: zwq
     * @date: 2020/5/28 0028 下午 2:13
     * @param activitySolidAward
     */
    public void andAward(ActivitySolidAward activitySolidAward) {
        checkAward(activitySolidAward);
        activitySolidAward.setDeleted(false);
        activitySolidAward.setUpdatedTime(new Date());
        activitySolidAward.setCreatedTime(new Date());
        activitySolidAwardMapper.insertSelective(activitySolidAward);
    }

    private void checkAward(ActivitySolidAward activitySolidAward) {
        //较验
        activitySolidAward.setId(UUIDUtils.generateUuid());
        if (StringUtils.isBlank(activitySolidAward.getName())) {
            throw new ServiceException("奖品名称不为空");
        }
        //preissueNum
        if (activitySolidAward.getPreissueNum() == null) {
            throw new ServiceException("预发数量不为空");
        }
        //预发数量==剩余数量
        if (activitySolidAward.getSurplusNum() == null) {
            activitySolidAward.setSurplusNum(activitySolidAward.getPreissueNum());
        }
        if (activitySolidAward.getPrice() == null || activitySolidAward.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ServiceException("单品价格不为空");
        }
        if (StringUtils.isBlank(activitySolidAward.getImageUrls())) {
            throw new ServiceException("图片地址不为空");
        }
        //奖品类型 1. 实物 2. 游戏 3. 酒店 4. 第三方合作 5.充值卡
        if (activitySolidAward.getType() == null) {
            throw new ServiceException("奖品类型不为空");
        }
        if (StringUtils.isBlank(activitySolidAward.getBranchId())) {
            throw new ServiceException("门店id不为空");
        }
        if (StringUtils.isBlank(activitySolidAward.getBranchName())) {
            throw new ServiceException("门店名称不为空");
        }
        // 视频平台 1. 爱奇艺 2. 腾讯视频 3.优酷会员
        if (activitySolidAward.getVideoPlatform() == null) {
            throw new ServiceException("选择 视频平台 1. 爱奇艺 2. 腾讯视频 3.优酷会员");
        }
        if (activitySolidAward.getTypeTime() == null) {
            throw new ServiceException("选择 时间类型 1.周卡 2. 月卡 3.年卡");
        }
        if (activitySolidAward.getStartTime() == null) {
            throw new ServiceException("兑换开始时间");
        }
        if (activitySolidAward.getEndTime() == null) {
            throw new ServiceException("兑换结束时间");
        }
        //兑换码类型 1. 系统兑换码 2. 视频会员兑换码
        activitySolidAward.setRedeemCodeType(1);
        if (StringUtils.isBlank(activitySolidAward.getCreatedBy())) {
            throw new ServiceException("创建人不为空");
        }
        if (StringUtils.isBlank(activitySolidAward.getUpdatedBy())) {
            throw new ServiceException("修改人不为空");
        }

    }

}
