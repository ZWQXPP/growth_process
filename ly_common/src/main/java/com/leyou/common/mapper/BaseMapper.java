package com.leyou.common.mapper;


import tk.mybatis.mapper.common.Mapper;

public interface BaseMapper<T> extends Mapper<T>,SpecialBatchMapper {

}
