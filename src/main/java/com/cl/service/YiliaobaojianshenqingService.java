package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YiliaobaojianshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiliaobaojianshenqingView;


/**
 * 医疗保健申请
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface YiliaobaojianshenqingService extends IService<YiliaobaojianshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiliaobaojianshenqingView> selectListView(Wrapper<YiliaobaojianshenqingEntity> wrapper);
   	
   	YiliaobaojianshenqingView selectView(@Param("ew") Wrapper<YiliaobaojianshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiliaobaojianshenqingEntity> wrapper);
   	

}

