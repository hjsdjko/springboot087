package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingshenweijiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingshenweijiView;


/**
 * 精神慰籍
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface JingshenweijiService extends IService<JingshenweijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingshenweijiView> selectListView(Wrapper<JingshenweijiEntity> wrapper);
   	
   	JingshenweijiView selectView(@Param("ew") Wrapper<JingshenweijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingshenweijiEntity> wrapper);
   	

}

