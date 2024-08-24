package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WenhuayuleshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenhuayuleshenqingView;


/**
 * 文化娱乐申请
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface WenhuayuleshenqingService extends IService<WenhuayuleshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenhuayuleshenqingView> selectListView(Wrapper<WenhuayuleshenqingEntity> wrapper);
   	
   	WenhuayuleshenqingView selectView(@Param("ew") Wrapper<WenhuayuleshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenhuayuleshenqingEntity> wrapper);
   	

}

