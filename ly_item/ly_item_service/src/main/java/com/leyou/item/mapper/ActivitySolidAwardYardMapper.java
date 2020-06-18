package com.leyou.item.mapper;

import com.leyou.common.mapper.BaseMapper;
import com.leyou.item.entity.ActivitySolidAwardYard;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ActivitySolidAwardYardMapper extends BaseMapper<ActivitySolidAwardYard> {

    void deleteYard(@Param("params")ActivitySolidAwardYard activitySolidAwardYard);

}
