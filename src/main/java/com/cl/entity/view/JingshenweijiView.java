package com.cl.entity.view;

import com.cl.entity.JingshenweijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 精神慰籍
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@TableName("jingshenweiji")
public class JingshenweijiView  extends JingshenweijiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingshenweijiView(){
	}
 
 	public JingshenweijiView(JingshenweijiEntity jingshenweijiEntity){
 	try {
			BeanUtils.copyProperties(this, jingshenweijiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
