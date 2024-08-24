package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenghuofuwushenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenghuofuwushenqingView;


/**
 * 生活服务申请
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface ShenghuofuwushenqingService extends IService<ShenghuofuwushenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenghuofuwushenqingView> selectListView(Wrapper<ShenghuofuwushenqingEntity> wrapper);
   	
   	ShenghuofuwushenqingView selectView(@Param("ew") Wrapper<ShenghuofuwushenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenghuofuwushenqingEntity> wrapper);
   	

}

