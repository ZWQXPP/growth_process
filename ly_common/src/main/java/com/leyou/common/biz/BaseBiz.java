package com.leyou.common.biz;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.annotation.Wildcard;
import com.leyou.common.mapper.BaseMapper;

import com.leyou.common.msg.TableResultResponse;
import com.leyou.common.utils.ArrayUtils;
import com.leyou.common.utils.EntityUtils;
import com.leyou.common.utils.Query;
import com.leyou.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mr.AG
 * Date: 17/1/13
 * Time: 15:13
 * Version 1.0.0
 */
public abstract class BaseBiz<M extends BaseMapper<T>, T> {

    private static final String SORT_NAME = "sortName";
    private static final String SORT_ORDER = "sortOrder";

    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }


    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }


    public void insert(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insert(entity);
    }

    public void insertList(List<T> entitys) {
        if(ArrayUtils.isNotNullAndEmpty(entitys)) {
            for (T entity :entitys) {
                EntityUtils.setCreatAndUpdatInfoBatch(entity);
            }
            mapper.insertListUseAllCols(entitys);
        }
    }


    public void insertSelective(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insertSelective(entity);
    }


    public void delete(T entity) {
        mapper.delete(entity);
    }


    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }


    public void updateById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKey(entity);
    }


    public void updateSelectiveById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKeySelective(entity);

    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public TableResultResponse<T> selectByQuery(Query query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Set<String> wildSet = new HashSet<>();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Wildcard.class)){
                wildSet.add(field.getName());
            }
        }

        Example example = new Example(clazz);
        if(query.entrySet().size()>0) {
            Example.Criteria criteria = example.createCriteria();
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if(!SORT_NAME.equalsIgnoreCase(entry.getKey()) && !SORT_ORDER.equalsIgnoreCase(entry.getKey())){
                    if(wildSet.size() > 0 && wildSet.contains(entry.getKey())){
                        criteria.andLike(entry.getKey(), "%" + entry.getValue().toString() + "%");
                    }else{
                        if("true".equals(entry.getValue().toString()) || "false".equals(entry.getValue().toString())){
                            criteria.andEqualTo(entry.getKey(), Boolean.parseBoolean(entry.getValue().toString()));
                        }else if (StringUtils.isNotBlank(entry.getValue().toString())) {
                            criteria.andEqualTo(entry.getKey(), entry.getValue().toString());
                        }
                    }
                }
            }
        }

        String sortName = (String)query.get(SORT_NAME);
        String sortOrder = (String)query.get(SORT_ORDER);

        if(StringUtils.isNotBlank(sortName)){
            example.setOrderByClause(StringUtils.humpToUnderLine(sortName) + " " + sortOrder);
        }

        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        return new TableResultResponse<T>(result.getTotal(), list);
    }
}
