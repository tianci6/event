package com.entity.view;

import com.entity.ShequchangdiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 社区场地
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）

 */
@TableName("shequchangdi")
public class ShequchangdiView  extends ShequchangdiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShequchangdiView(){
	}
 
 	public ShequchangdiView(ShequchangdiEntity shequchangdiEntity){
 	try {
			BeanUtils.copyProperties(this, shequchangdiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
