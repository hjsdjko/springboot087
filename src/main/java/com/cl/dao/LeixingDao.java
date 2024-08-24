package com.cl.dao;

import com.cl.entity.LeixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LeixingView;


/**
 * 类型
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface LeixingDao extends BaseMapper<LeixingEntity> {
	
	List<LeixingView> selectListView(@Param("ew") Wrapper<LeixingEntity> wrapper);

	List<LeixingView> selectListView(Pagination page,@Param("ew") Wrapper<LeixingEntity> wrapper);
	
	LeixingView selectView(@Param("ew") Wrapper<LeixingEntity> wrapper);
	

}
