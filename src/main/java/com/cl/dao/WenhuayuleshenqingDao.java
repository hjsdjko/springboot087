package com.cl.dao;

import com.cl.entity.WenhuayuleshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenhuayuleshenqingView;


/**
 * 文化娱乐申请
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface WenhuayuleshenqingDao extends BaseMapper<WenhuayuleshenqingEntity> {
	
	List<WenhuayuleshenqingView> selectListView(@Param("ew") Wrapper<WenhuayuleshenqingEntity> wrapper);

	List<WenhuayuleshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<WenhuayuleshenqingEntity> wrapper);
	
	WenhuayuleshenqingView selectView(@Param("ew") Wrapper<WenhuayuleshenqingEntity> wrapper);
	

}
