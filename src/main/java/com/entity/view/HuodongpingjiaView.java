package com.entity.view;

import com.entity.HuodongpingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）

 */
@TableName("huodongpingjia")
public class HuodongpingjiaView  extends HuodongpingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongpingjiaView(){
	}
 
 	public HuodongpingjiaView(HuodongpingjiaEntity huodongpingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, huodongpingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
