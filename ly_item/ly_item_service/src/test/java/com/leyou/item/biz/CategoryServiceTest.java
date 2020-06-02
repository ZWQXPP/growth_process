package com.leyou.item.biz;

import com.leyou.LyItemApplication;
import com.leyou.item.entity.ActivitySolidAward;
import com.leyou.item.entity.ActivitySolidAwardYard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import serviceVo.ActivitySolidAwardYardVo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LyItemApplication.class)
public class CategoryServiceTest {


    @Autowired
    private ActivitySolidAwardBiz activitySolidAwardBiz;
    @Autowired
    private ActivitySolidAwardYardBiz activitySolidAwardYardBiz;

    @Test
    public void findaa() {
        ActivitySolidAward aa = activitySolidAwardBiz.findAward("654a161bed9645fcb7ccd8c916b838b7");
        System.out.println(aa);
    }
    @Test
    public void findyawrd() {
        ActivitySolidAwardYard award = new ActivitySolidAwardYard();
        award.setActivitySolidAwardId("1456711221");
        activitySolidAwardYardBiz.deleteYard(award);
    }

    @Test
    public void addYard() {
        ActivitySolidAwardYardVo activitySolidAwardYard = new ActivitySolidAwardYardVo();
        for (int i = 0; i < 6; i++) {
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
        award.setName("夹心面包");
        award.setPreissueNum(188);
        award.setPrice(new BigDecimal("50"));
        award.setImageUrls("na34yhyygq23uuvhf");
        award.setType(3);
        award.setBranchId("321");
        award.setBranchName("绿地店234");
        award.setVideoPlatform(2);
        award.setTypeTime(2);
        award.setStartTime(new Date());
        award.setCreatedBy("尊上");
        award.setUpdatedBy("一一");
        //时间推一个月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1); //把日期往后增加一个月，整数往后推，负数往前移
        date = calendar.getTime();
        // String stringDate = sdf.format(date);//date-->String
        award.setEndTime(date);
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