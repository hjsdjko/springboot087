package com.cl.entity.view;

import com.cl.entity.LaorenjiashuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 老人家属
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@TableName("laorenjiashu")
public class LaorenjiashuView  extends LaorenjiashuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LaorenjiashuView(){
	}
 
 	public LaorenjiashuView(LaorenjiashuEntity laorenjiashuEntity){
 	try {
			BeanUtils.copyProperties(this, laorenjiashuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
