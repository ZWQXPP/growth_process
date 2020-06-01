package com.leyou.item.controller;

import com.leyou.item.biz.ActivitySolidAwardBiz;
import com.leyou.item.entity.ActivitySolidAward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity/award")
public class ActivitySolidAwardController extends ActivitySolidAwardBiz {
    @Autowired
    private ActivitySolidAwardBiz activitySolidAwardBiz;

    @GetMapping("/find")
    public ActivitySolidAward findAward(@RequestParam String id){
        ActivitySolidAward award = activitySolidAwardBiz.findAward(id);
        return award;
    }
    /**
     * @Description: 奖品添加
     * @auther: zwq
     * @date: 2020/5/28 0028 下午 2:13
     */
    @PostMapping("/add")
    public void addAward(@RequestBody ActivitySolidAward activitySolidAward) {
        activitySolidAwardBiz.andAward(activitySolidAward);
    }
}
