package com.leyou.item.controller;

import com.leyou.common.rest.BaseController;
import com.leyou.common.utils.DateUtils;
import com.leyou.common.utils.ExcelUtil;
import com.leyou.item.biz.ActivitySolidAwardBiz;
import com.leyou.item.entity.ActivitySolidAward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serviceVo.ActivitySolidAwardVo;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/activity/award")
public class ActivitySolidAwardController extends BaseController<ActivitySolidAwardBiz,ActivitySolidAward>  {
    @Autowired
    private ActivitySolidAwardBiz activitySolidAwardBiz;

    @GetMapping("/find")
    public List<String> findAward(@RequestParam ActivitySolidAward activitySolidAward){
        return  activitySolidAwardBiz.findAward(activitySolidAward);

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
    /**
     * @Description: 方法是1
     * @param:
     * @return:
     * @auther: zwq
     * @date: 2020/6/1 0001 下午 4:16
     */
    @GetMapping
    public void demo01 (@RequestParam ActivitySolidAward activitySolidAward){

        System.out.println("测试001"+activitySolidAward);
    }

    @PostMapping("/export")
    public void productExport(@RequestBody ActivitySolidAwardVo activitySolidAward, HttpServletResponse response){
        String ids = "654a161bed9645fcb7ccd8c916b838b7";
        activitySolidAward.setIds(ids);
        List<ActivitySolidAwardVo> vos = activitySolidAwardBiz.selectAwardListByIds(activitySolidAward.getIds());
        List<List<Object>> exportData = new ArrayList<List<Object>>();
        for (ActivitySolidAwardVo vo :vos){
            List<Object> dataList = new ArrayList<>();

            dataList.add(vo.getName());
            dataList.add(vo.hashCode());
            exportData.add(dataList);
        }
        List<String> headerList = new ArrayList<String>();
        headerList.add("奖品名称");
        headerList.add("奖品编号");
        ExcelUtil.createExcel(exportData,headerList,"商品列表",response);
    }



}
