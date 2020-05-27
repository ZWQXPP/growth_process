package com.leyou.item.mapper;

import com.leyou.item.entity.ActivitySolidAward;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface ActivitySolidAwardMapper extends Mapper<ActivitySolidAward> {

    ActivitySolidAward selectAward(@Param("id") String id);
}
