package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LaorenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaorenView;


/**
 * 老人
 *
 * @author 
 * @email 
 * @date 2024-04-05 19:14:12
 */
public interface LaorenService extends IService<LaorenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaorenView> selectListView(Wrapper<LaorenEntity> wrapper);
   	
   	LaorenView selectView(@Param("ew") Wrapper<LaorenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaorenEntity> wrapper);
   	

}

