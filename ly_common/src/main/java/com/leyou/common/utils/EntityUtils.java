package com.leyou.common.utils;

import com.leyou.common.context.BaseContextHandler;

import org.apache.commons.lang3.StringUtils;


import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;


public class EntityUtils {
	private static final String[] created_fields = {"createdTime","createdBy","deleted"};
	private static final String[] updated_fields = {"updatedTime","updatedBy"};

	private static final String[] created_batch_fields = {"createdTime","createdBy","deleted","id"};
	private static final String[] updated_batch_fields = {"updatedTime","updatedBy"};


	public static <T> void setCreatAndUpdatInfo(T entity) {
		setCreateInfo(entity);
		setUpdatedInfo(entity);
	}

	public static <T> void setCreatAndUpdatInfoBatch(T entity){
		setCreateInfoBatch(entity);
		setUpdatedInfoBatch(entity);
	}

	public static <T> void setCreateInfoBatch(T entity){
		String userId = BaseContextHandler.getUserID();
		userId = StringUtils.isNotBlank(userId)? userId : "system";
                    //ReflectionUtils
		Field field = ReflectionUtils.getAccessibleField(entity, "createdTime");
		// 默认值
		if(field!=null){
			Object [] value = new Object []{new Timestamp(System.currentTimeMillis()),userId,false,UUIDUtils.generateUuid()};
			// 填充默认属性值
			setDefaultValues(entity, created_batch_fields, value);
		}

	}

	public static <T> void setCreateInfo(T entity){
		String userId = BaseContextHandler.getUserID();
		userId = StringUtils.isNotBlank(userId)? userId : "system";

		Field field = ReflectionUtils.getAccessibleField(entity, "createdTime");
		// 默认值
		if(field!=null){
			Object [] value = new Object []{new Date(System.currentTimeMillis()),userId,false};
			// 填充默认属性值
			setDefaultValues(entity, created_fields, value);
		}

	}

	public static <T> void setUpdatedInfoBatch(T entity){
		String userId = BaseContextHandler.getUserID();
		userId = StringUtils.isNotBlank(userId)? userId : "system";

		Field field = ReflectionUtils.getAccessibleField(entity, "updatedTime");
		if(field!=null){
			Object [] value = new Object []{new Timestamp(System.currentTimeMillis()),userId};
			// 填充默认属性值
			setDefaultValues(entity, updated_batch_fields, value);
		}

	}


	public static <T> void setUpdatedInfo(T entity){
		String userId = BaseContextHandler.getUserID();
		userId = StringUtils.isNotBlank(userId)? userId : "system";

		Field field = ReflectionUtils.getAccessibleField(entity, "updatedTime");
		if(field!=null){
			Object [] value = new Object []{new Date(System.currentTimeMillis()),userId};
			// 填充默认属性值
			setDefaultValues(entity, updated_fields, value);
		}

	}

	private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
		for(int i=0;i<fields.length;i++){
			String field = fields[i];
			if(ReflectionUtils.hasField(entity, field)){
				ReflectionUtils.invokeSetter(entity, field, value[i]);
			}
		}
	}

}
