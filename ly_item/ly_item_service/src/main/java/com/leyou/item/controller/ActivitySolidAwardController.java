package com.leyou.item.controller;

import com.leyou.item.biz.ActivitySolidAwardBiz;
import com.leyou.item.entity.ActivitySolidAward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
