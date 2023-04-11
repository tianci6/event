package com.entity.view;

import com.entity.QuxiaobaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 取消报名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）

 */
@TableName("quxiaobaoming")
public class QuxiaobaomingView  extends QuxiaobaomingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QuxiaobaomingView(){
	}
 
 	public QuxiaobaomingView(QuxiaobaomingEntity quxiaobaomingEntity){
 	try {
			BeanUtils.copyProperties(this, quxiaobaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
