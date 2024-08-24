package com.cl.entity.view;

import com.cl.entity.ShenghuofuwushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 生活服务申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@TableName("shenghuofuwushenqing")
public class ShenghuofuwushenqingView  extends ShenghuofuwushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenghuofuwushenqingView(){
	}
 
 	public ShenghuofuwushenqingView(ShenghuofuwushenqingEntity shenghuofuwushenqingEntity){
 	try {
			BeanUtils.copyProperties(this, shenghuofuwushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
