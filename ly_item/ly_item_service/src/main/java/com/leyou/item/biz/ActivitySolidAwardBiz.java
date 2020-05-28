package com.leyou.item.biz;

import com.leyou.item.entity.ActivitySolidAward;
import com.leyou.item.mapper.ActivitySolidAwardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ActivitySolidAwardBiz  {
    @Autowired
    private ActivitySolidAwardMapper activitySolidAwardMapper;

    public ActivitySolidAward findAward(String id) {
        return  activitySolidAwardMapper.selectAward(id);
    }

    /**
     * @Description: 奖品添加
     * @auther: zwq
     * @date: 2020/5/28 0028 下午 2:13
     */
    public void andAward() {

    }
}
