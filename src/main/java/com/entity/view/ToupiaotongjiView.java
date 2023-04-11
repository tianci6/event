package com.entity.view;

import com.entity.ToupiaotongjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 投票统计
 * 后端返回视图实体辅助类   

 */
@TableName("toupiaotongji")
public class ToupiaotongjiView  extends ToupiaotongjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ToupiaotongjiView(){
	}
 
 	public ToupiaotongjiView(ToupiaotongjiEntity toupiaotongjiEntity){
 	try {
			BeanUtils.copyProperties(this, toupiaotongjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
