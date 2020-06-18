package com.leyou.common.mapper;

import com.leyou.common.provider.SpecialBatchProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @ClassName SpecialBatchMapper
 * @Description
 * @Author
 * @Date 2019/7/4 20:35
 * @Version V1.0
 **/

@RegisterMapper
public interface SpecialBatchMapper<T> {
    /**
     * 批量插入数据库，所有字段都插入，包括主键
     *
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @InsertProvider(type = SpecialBatchProvider.class, method = "dynamicSQL")
    int insertListUseAllCols(List<T> recordList);

}
