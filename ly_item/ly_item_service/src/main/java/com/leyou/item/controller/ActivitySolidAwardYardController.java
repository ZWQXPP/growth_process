package com.leyou.item.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.msg.ObjectRestResponse;
import com.leyou.common.msg.TableResultResponse;
import com.leyou.common.rest.BaseController;
import com.leyou.item.biz.ActivitySolidAwardYardBiz;
import com.leyou.item.entity.ActivitySolidAwardYard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serviceVo.ActivitySolidAwardYardVo;

import java.util.List;

@RestController
@RequestMapping("/activity/yard")
public class ActivitySolidAwardYardController extends BaseController<ActivitySolidAwardYardBiz,ActivitySolidAwardYard> {

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

    @DeleteMapping("deleteYard")
    public void deleteYard(@RequestParam ActivitySolidAwardYard activitySolidAwardYard){
        awardYardBiz.deleteYard(activitySolidAwardYard);
    }
    
    /**
     * @Description: 方法是
     * @auther: zwq
     * @date: 2020/6/18 0018 下午 4:59
     */
    @GetMapping("/ssssss")
    public TableResultResponse findYard(@RequestParam(defaultValue = "false") String id,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer limit){
        Page result = PageHelper.startPage(page, limit);
        List<String> list = this.baseBiz.findSolidAwardYardList(id);
        return new TableResultResponse(result.getTotal(), list);
    }

    /**
     * @Description: 列表
     * @param:
     * @auther: zwq
     * @date: 2020/7/22 0022 下午 2:47
     */
    @GetMapping("/yardList")
    public ObjectRestResponse yardList(@RequestParam ActivitySolidAwardYardVo activitySolidAwardYardVo){
        ObjectRestResponse restResponse = new ObjectRestResponse();

        restResponse.setData(this.awardYardBiz.yardList(activitySolidAwardYardVo));
        return restResponse;
    }
}
