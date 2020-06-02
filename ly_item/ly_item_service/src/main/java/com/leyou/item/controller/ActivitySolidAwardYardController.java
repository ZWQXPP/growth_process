package com.leyou.item.controller;

import com.leyou.item.biz.ActivitySolidAwardYardBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity/yard")
public class ActivitySolidAwardYardController extends ActivitySolidAwardYardBiz {

    @Autowired
    private ActivitySolidAwardYardBiz awardYardBiz;

    @PostMapping("/add")
    public void addYard(@RequestBody ActivitySolidAwardYardVo activitySolidAwardYardVo){
        this.awardYardBiz.addYard(activitySolidAwardYardVo);
    }

    @GetMapping
    public void updateYard(@RequestParam ActivitySolidAwardYardVo activitySolidAwardYardVo){
        awardYardBiz.updateYard(activitySolidAwardYardVo);

    }
}
