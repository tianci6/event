package com.entity.view;


import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ReportEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("report")
public class ReportView extends ReportEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public ReportView(){

    }

    public ReportView(ReportEntity reportEntity){
        try {
            BeanUtils.copyProperties(this, reportEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
