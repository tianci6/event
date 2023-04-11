package com.entity.view;

import com.entity.DiscussshequchangdiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 社区场地评论表
 * 后端返回视图实体辅助类   


 */
@TableName("discussshequchangdi")
public class DiscussshequchangdiView  extends DiscussshequchangdiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshequchangdiView(){
	}
 
 	public DiscussshequchangdiView(DiscussshequchangdiEntity discussshequchangdiEntity){
 	try {
			BeanUtils.copyProperties(this, discussshequchangdiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
