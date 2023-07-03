package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.AnnoucementEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**

 */
@TableName("announcement")
public class AnnouncementView extends AnnoucementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AnnouncementView(){
	}

 	public AnnouncementView(AnnoucementEntity annoucement){
 	try {
			BeanUtils.copyProperties(this, annoucement);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
