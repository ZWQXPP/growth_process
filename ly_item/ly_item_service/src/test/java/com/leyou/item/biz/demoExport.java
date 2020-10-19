package com.leyou.item.biz;

import com.leyou.LyItemApplication;
import com.leyou.item.controller.ActivitySolidAwardController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import serviceVo.ActivitySolidAwardVo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LyItemApplication.class)
public class demoExport {

    @Autowired
    private ActivitySolidAwardController awardController;

    @Test
    public void test01(){
        ActivitySolidAwardVo activitySolidAwardVo = new ActivitySolidAwardVo();

    }
}
