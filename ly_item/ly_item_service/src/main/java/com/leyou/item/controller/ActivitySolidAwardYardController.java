package com.leyou.item.controller;

import com.leyou.common.vo.ActivitySolidAwardYardVo;
import com.leyou.item.biz.ActivitySolidAwardYardBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity/yard")
public class ActivitySolidAwardYardController extends ActivitySolidAwardYardBiz {

    @Autowired
    private ActivitySolidAwardYardBiz awardYardBiz;
    @PostMapping("/add")
    public void addYard(@RequestBody ActivitySolidAwardYardVo activitySolidAwardYardVo){
        this.awardYardBiz.addYard(activitySolidAwardYardVo);

    }
}
