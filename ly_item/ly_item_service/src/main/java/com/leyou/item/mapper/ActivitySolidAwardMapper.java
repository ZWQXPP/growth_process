package com.leyou.item.mapper;

import com.leyou.item.entity.ActivitySolidAward;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface ActivitySolidAwardMapper extends Mapper<ActivitySolidAward> {

    List<ActivitySolidAward> selectAward(@Param("params") ActivitySolidAward activitySolidAward);
}
