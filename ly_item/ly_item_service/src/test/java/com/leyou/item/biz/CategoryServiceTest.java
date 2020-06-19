package com.leyou.item.biz;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.leyou.LyItemApplication;
import com.leyou.common.utils.JsonUtils;
import com.leyou.item.entity.ActivitySolidAward;
import com.leyou.item.entity.ActivitySolidAwardYard;
import com.leyou.item.mapper.ActivitySolidAwardYardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import serviceVo.ActivitySolidAwardYardVo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LyItemApplication.class)
public class CategoryServiceTest {


    @Autowired
    private ActivitySolidAwardBiz activitySolidAwardBiz;
    @Autowired
    private ActivitySolidAwardYardBiz activitySolidAwardYardBiz;
    @Autowired
    private ActivitySolidAwardYardMapper activitySolidAwardYardMapper;

    @Test
    public void findaa() {
        ActivitySolidAward award = new ActivitySolidAward();
        List<String> aa =  activitySolidAwardBiz.findAward(award);
        System.out.println(aa);
    }

    @Test
    public void deleteYard() {
       /* ActivitySolidAwardYard award = new ActivitySolidAwardYard();
        award.setActivitySolidAwardId("1456711221");*/
        List<ActivitySolidAwardYardVo> vos =  activitySolidAwardYardMapper.findSolidAwardYardList("");
      //  List<ActivitySolidAwardYardVo> vos = activitySolidAwardYardBiz.findSolidAwardYardList("");
         List<String> ids = vos.stream().map(ActivitySolidAwardYardVo::getId).collect(Collectors.toList());
        //List<String> ids = new ArrayList<>();
       /* vos.forEach(item -> {
            ids.add(item.getId());
        });*/
        System.out.println(JsonUtils.toString(ids));

    }

    @Test
    public void addYard() {
        ActivitySolidAwardYardVo activitySolidAwardYard = new ActivitySolidAwardYardVo();
        for (int i = 0; i < 8; i++) {
            activitySolidAwardYard.setId("363f60fe4ab2e0c3a7f9a332");
            activitySolidAwardYard.setActivitySolidAwardId("1456711221");
            activitySolidAwardYard.setActivitySolidYard("aac11chdcss");
            activitySolidAwardYard.setUpdatedBy("尊上");
            activitySolidAwardYardBiz.addYard(activitySolidAwardYard);
        }
    }

    @Test
    public void addAward(){
        ActivitySolidAward award = new ActivitySolidAward();
        award.setName("面包34567");
        award.setPreissueNum(18);
        award.setPrice(new BigDecimal("50"));
        award.setImageUrls("na34yhyygq23uuvhf");
        award.setType(3);
        award.setBranchId("321");
        award.setBranchName("注意点");
        award.setVideoPlatform(2);
        award.setTypeTime(2);
        award.setStartTime(new Date());
        /*award.setCreatedBy("尊上");
        award.setUpdatedBy("一一");*/
        activitySolidAwardBiz.andAward(award);
    }

    @Test
    public void updetaYard() {
        ActivitySolidAwardYardVo activitySolidAwardYard = new ActivitySolidAwardYardVo();

            activitySolidAwardYard.setId("09caf3f37ce04b23848eb8e6c37f21df");
            activitySolidAwardYard.setActivitySolidAwardId("221");
            activitySolidAwardYard.setType(1);
            activitySolidAwardYardBiz.updateYard(activitySolidAwardYard);
        }


}