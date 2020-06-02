package com.leyou.item.mapper;

import com.leyou.item.entity.ActivitySolidAwardYard;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ActivitySolidAwardYardMapper extends Mapper<ActivitySolidAwardYard> {

    void deleteYard(@Param("params")ActivitySolidAwardYard activitySolidAwardYard);

}
