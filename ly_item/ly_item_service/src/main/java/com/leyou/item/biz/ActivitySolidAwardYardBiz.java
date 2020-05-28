package com.leyou.item.biz;

import com.leyou.common.exception.ServiceException;
import com.leyou.common.utils.StringUtils;
import com.leyou.common.utils.UUIDUtils;
import com.leyou.common.vo.ActivitySolidAwardYardVo;
import com.leyou.item.entity.ActivitySolidAwardYard;
import com.leyou.item.enums.ActivitySolidAwardYardTypes;
import com.leyou.item.mapper.ActivitySolidAwardYardMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivitySolidAwardYardBiz {

    @Autowired
    private  ActivitySolidAwardYardMapper awardYardMapper;

        public void addYard(ActivitySolidAwardYardVo activitySolidAwardYardVo) {
        checkAwardYard(activitySolidAwardYardVo);
            ActivitySolidAwardYard activitySolidAwardYard = new ActivitySolidAwardYard();
            activitySolidAwardYardVo.setDeleted(false);
            activitySolidAwardYardVo.setUpdatedTime(new Date());
            activitySolidAwardYardVo.setCreatedTime(new Date());
            BeanUtils.copyProperties(activitySolidAwardYardVo,activitySolidAwardYard);
            if (activitySolidAwardYard == null){
                awardYardMapper.insert(activitySolidAwardYard);
            }else {
                awardYardMapper.updateByPrimaryKeySelective( activitySolidAwardYard);
            }


    }

    private void checkAwardYard(ActivitySolidAwardYardVo activitySolidAwardYardVo) {
            //详情
        ActivitySolidAwardYard activitySolidAwardYard = awardYardMapper.selectByPrimaryKey(activitySolidAwardYardVo.getId());
        //判断验证码是否为空
        if (activitySolidAwardYard == null){
            if (activitySolidAwardYardVo.getActivitySolidAwardId()==null){
                throw new ServiceException("实体奖品ID不为空");
            }
            if (activitySolidAwardYardVo.getActivitySolidYard() == null){
                throw  new ServiceException("兑换码不为空");
            }
            activitySolidAwardYardVo.setId(UUIDUtils.generateUuid());
            activitySolidAwardYardVo.setType(ActivitySolidAwardYardTypes.ZERO.getType());

        }else {
            if (StringUtils.isBlank(activitySolidAwardYardVo.getUpdatedBy())){
                throw new  ServiceException("beizhu修改人");
            }
            if (activitySolidAwardYard.getType().equals(ActivitySolidAwardYardTypes.ONE.getType())){
                throw new  ServiceException("兑奖码状态不正确");
            }
            activitySolidAwardYardVo.setType(ActivitySolidAwardYardTypes.ONE.getType());
        }

    }

}
