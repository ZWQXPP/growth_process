package com.leyou.common.rest;


import com.leyou.common.biz.BaseBiz;
import com.leyou.common.context.BaseContextHandler;
import com.leyou.common.msg.ObjectRestResponse;
import com.leyou.common.msg.TableResultResponse;
import com.leyou.common.utils.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
public class BaseController<Biz extends BaseBiz,Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;

    @PostMapping("")
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ObjectRestResponse<Entity>();
    }

    @GetMapping("/{id}")
    public ObjectRestResponse<Entity> get(@PathVariable String id){
        ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
        Object o = baseBiz.selectById(id);
        entityObjectRestResponse.data((Entity)o);
        return entityObjectRestResponse;
    }

    @PostMapping("/{id}")
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
        baseBiz.updateSelectiveById(entity);
        return new ObjectRestResponse<Entity>();
    }

    @GetMapping("/all")
    public List<Entity> all(){
        return baseBiz.selectListAll();
    }

    @GetMapping("/page")
    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        return baseBiz.selectByQuery(query);
    }

    @GetMapping("/list/criteria")
    public ObjectRestResponse<List<Entity>> list(Entity entity){
        ObjectRestResponse<List<Entity>> entityObjectRestResponse = new ObjectRestResponse<>();
        List<Entity> list = baseBiz.selectList(entity);
        entityObjectRestResponse.data(list);
        return entityObjectRestResponse;
    }

    public String getCurrentUserName(){
        return BaseContextHandler.getUsername();
    }

    public String getCurrentUserId(){
        return BaseContextHandler.getUserID();
    }
}
