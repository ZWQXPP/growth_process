package com.leyou.item.biz;

import com.leyou.LyItemApplication;
import com.leyou.common.vo.ActivitySolidAwardYardVo;
import com.leyou.item.dto.CategoryDTO;
import com.leyou.item.entity.ActivitySolidAward;
import com.leyou.item.entity.ActivitySolidAwardYard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LyItemApplication.class)
public class CategoryServiceTest {


    @Autowired
    private ActivitySolidAwardBiz activitySolidAwardBiz;
    @Autowired
    private ActivitySolidAwardYardBiz activitySolidAwardYardBiz;

    @Test
    public void aVoid() {
        ActivitySolidAward aa = activitySolidAwardBiz.findAward("34645");
        System.out.println(aa);
    }

    @Test
    public void addYard() {
        ActivitySolidAwardYardVo activitySolidAwardYard =new ActivitySolidAwardYardVo();
        activitySolidAwardYard.setId("363f60fe91744e4ab2e0fac3a7f9a332");
        activitySolidAwardYard.setActivitySolidAwardId("1456711221");
        activitySolidAwardYard.setActivitySolidYard("aac11chdcss");
        activitySolidAwardYard.setUpdatedBy("李四234");
        activitySolidAwardYardBiz.addYard(activitySolidAwardYard);
        System.out.println(activitySolidAwardYard);
    }
}