package com.leyou.item.biz;

import com.leyou.common.biz.BaseBiz;
import com.leyou.common.exception.ServiceException;
import com.leyou.common.utils.EntityUtils;
import com.leyou.common.utils.StringUtils;
import com.leyou.common.utils.UUIDUtils;
import com.leyou.item.entity.ActivitySolidAward;
import com.leyou.item.mapper.ActivitySolidAwardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ActivitySolidAwardBiz extends BaseBiz<ActivitySolidAwardMapper,ActivitySolidAward> {
    @Autowired
    private ActivitySolidAwardMapper activitySolidAwardMapper;

    public List<String> findAward(ActivitySolidAward activitySolidAward) {
        List<ActivitySolidAward> aa =   this.activitySolidAwardMapper.selectAward(activitySolidAward);
        List<String> list = new ArrayList<>();
        for (ActivitySolidAward award : aa) {
            String id = award.getId();
            list.add(id);
        }
        for (ActivitySolidAward award : aa) {
            String id = award.getId();
            list.add(id);
        }
      //  String a = new Gson().toJson(list);
        // return  JsonUtils.toString(list);
        return list;
    }

    /**
     * @Description: 奖品添加
     * @auther: zwq
     * @date: 2020/5/28 0028 下午 2:13
     * @param activitySolidAward
     */
    public void andAward(ActivitySolidAward activitySolidAward) {
        checkAward(activitySolidAward);
        EntityUtils.setCreatAndUpdatInfo(activitySolidAward);
        this.insertSelective(activitySolidAward);
    }

    private void checkAward(ActivitySolidAward activitySolidAward) {



        activitySolidAward.setId(UUIDUtils.generateUuid());
        //较验
        if (StringUtils.isBlank(activitySolidAward.getName())) {
            throw new ServiceException("奖品名称不为空");
        }
        //preissueNum
        if (activitySolidAward.getPreissueNum() == null || activitySolidAward.getPreissueNum() <= 0) {
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

        //时间推一个月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1); //把日期往后增加一个月，整数往后推，负数往前移
        date = calendar.getTime();
        // String stringDate = sdf.format(date);//date-->String
        activitySolidAward.setEndTime(date);
        //兑换码类型 1. 系统兑换码 2. 视频会员兑换码
        activitySolidAward.setRedeemCodeType(1);


    }

}
