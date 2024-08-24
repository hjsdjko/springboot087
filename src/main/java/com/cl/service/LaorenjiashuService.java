package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LaorenjiashuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaorenjiashuView;


/**
 * 老人家属
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface LaorenjiashuService extends IService<LaorenjiashuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaorenjiashuView> selectListView(Wrapper<LaorenjiashuEntity> wrapper);
   	
   	LaorenjiashuView selectView(@Param("ew") Wrapper<LaorenjiashuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaorenjiashuEntity> wrapper);
   	

}

