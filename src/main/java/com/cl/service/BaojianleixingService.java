package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.BaojianleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaojianleixingView;


/**
 * 保健类型
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface BaojianleixingService extends IService<BaojianleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaojianleixingView> selectListView(Wrapper<BaojianleixingEntity> wrapper);
   	
   	BaojianleixingView selectView(@Param("ew") Wrapper<BaojianleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaojianleixingEntity> wrapper);
   	

}

