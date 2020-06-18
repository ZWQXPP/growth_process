package com.leyou.item.mapper;

import com.leyou.common.mapper.BaseMapper;
import com.leyou.item.entity.ActivitySolidAwardYard;
import org.apache.ibatis.annotations.Param;
import serviceVo.ActivitySolidAwardYardVo;

import java.util.List;

public interface ActivitySolidAwardYardMapper extends BaseMapper<ActivitySolidAwardYard> {

    void deleteYard(@Param("params")ActivitySolidAwardYard activitySolidAwardYard);

    List<ActivitySolidAwardYardVo> findSolidAwardYardList(@Param("id")String id);
}
