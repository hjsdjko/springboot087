package com.cl.dao;

import com.cl.entity.ShenghuofuwushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenghuofuwushenqingView;


/**
 * 生活服务申请
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface ShenghuofuwushenqingDao extends BaseMapper<ShenghuofuwushenqingEntity> {
	
	List<ShenghuofuwushenqingView> selectListView(@Param("ew") Wrapper<ShenghuofuwushenqingEntity> wrapper);

	List<ShenghuofuwushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ShenghuofuwushenqingEntity> wrapper);
	
	ShenghuofuwushenqingView selectView(@Param("ew") Wrapper<ShenghuofuwushenqingEntity> wrapper);
	

}
