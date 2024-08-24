package com.cl.entity.view;

import com.cl.entity.LaorenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 老人
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:12
 */
@TableName("laoren")
public class LaorenView  extends LaorenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaorenView(){
	}
 
 	public LaorenView(LaorenEntity laorenEntity){
 	try {
			BeanUtils.copyProperties(this, laorenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
