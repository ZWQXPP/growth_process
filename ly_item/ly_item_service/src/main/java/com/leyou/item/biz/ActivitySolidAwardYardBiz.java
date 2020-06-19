package com.leyou.item.biz;

import com.leyou.common.biz.BaseBiz;
import com.leyou.common.exception.ServiceException;
import com.leyou.common.utils.StringUtils;
import com.leyou.common.utils.UUIDUtils;
import com.leyou.item.entity.ActivitySolidAwardYard;
import com.leyou.item.enums.ActivitySolidAwardYardTypes;
import com.leyou.item.mapper.ActivitySolidAwardYardMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serviceVo.ActivitySolidAwardYardVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivitySolidAwardYardBiz extends BaseBiz<ActivitySolidAwardYardMapper,ActivitySolidAwardYard> {

    @Autowired
    private ActivitySolidAwardYardMapper awardYardMapper;

    public void addYard(ActivitySolidAwardYardVo activitySolidAwardYardVo) {

            checkAwardYard(activitySolidAwardYardVo);
            ActivitySolidAwardYard activitySolidAwardYard = new ActivitySolidAwardYard();
            activitySolidAwardYardVo.setDeleted(false);
            activitySolidAwardYardVo.setUpdatedTime(new Date());
            activitySolidAwardYardVo.setCreatedTime(new Date());
            BeanUtils.copyProperties(activitySolidAwardYardVo, activitySolidAwardYard);
            if (activitySolidAwardYard == null) {
                awardYardMapper.updateByPrimaryKeySelective(activitySolidAwardYard);
            } else {
                awardYardMapper.insert(activitySolidAwardYard);
            }


    }

    private void checkAwardYard(ActivitySolidAwardYardVo activitySolidAwardYardVo) {
        //详情
        ActivitySolidAwardYard activitySolidAwardYard = awardYardMapper.selectByPrimaryKey(activitySolidAwardYardVo.getId());
        //判断验证码是否为空
        if (activitySolidAwardYard == null) {
            if (activitySolidAwardYardVo.getActivitySolidAwardId() == null) {
                throw new ServiceException("实体奖品ID不为空");
            }
            if (activitySolidAwardYardVo.getActivitySolidYard() == null) {
                throw new ServiceException("兑换码不为空");
            }
            activitySolidAwardYardVo.setId(UUIDUtils.generateUuid());
            activitySolidAwardYardVo.setType(ActivitySolidAwardYardTypes.ZERO.getType());

        } else {
            if (StringUtils.isBlank(activitySolidAwardYardVo.getUpdatedBy())) {
                throw new ServiceException("beizhu修改人");
            }
            if (activitySolidAwardYard.getType().equals(ActivitySolidAwardYardTypes.ONE.getType())) {
                throw new ServiceException("兑奖码状态不正确");
            }
            activitySolidAwardYardVo.setType(ActivitySolidAwardYardTypes.ONE.getType());
        }
    }

    public void updateYard(ActivitySolidAwardYardVo activitySolidAwardYardVo) {
        ActivitySolidAwardYard awardYard = new ActivitySolidAwardYard();
        awardYard.setActivitySolidAwardId(activitySolidAwardYardVo.getActivitySolidAwardId());
        awardYard.setId(activitySolidAwardYardVo.getId());
        awardYard.setType(activitySolidAwardYardVo.getType());
        awardYardMapper.updateByPrimaryKeySelective(awardYard);

    }


    public void deleteYard(ActivitySolidAwardYard activitySolidAwardYard) {
        awardYardMapper.deleteYard(activitySolidAwardYard);

    }

    public List<String> findSolidAwardYardList(String id) {

        List<ActivitySolidAwardYardVo> vos = this.mapper.findSolidAwardYardList(id);
        List<String> ids = new ArrayList<>();
      // List<String> ids = vos.stream().map(ActivitySolidAwardYardVo::getId).collect(Collectors.toList());
       /* List<String> ids = new ArrayList<>();
        for (ActivitySolidAwardYardVo vo : vos) {
                ids.add(vo.getId());
        }*/

        vos.forEach(item -> {
            ids.add(item.getId());
        });

        return ids;
    }
}
