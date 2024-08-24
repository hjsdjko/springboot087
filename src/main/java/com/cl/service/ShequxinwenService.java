package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShequxinwenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShequxinwenView;


/**
 * 社区新闻
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface ShequxinwenService extends IService<ShequxinwenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShequxinwenView> selectListView(Wrapper<ShequxinwenEntity> wrapper);
   	
   	ShequxinwenView selectView(@Param("ew") Wrapper<ShequxinwenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShequxinwenEntity> wrapper);
   	

}

