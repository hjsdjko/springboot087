package com.cl.dao;

import com.cl.entity.LaorenjiashuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaorenjiashuView;


/**
 * 老人家属
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface LaorenjiashuDao extends BaseMapper<LaorenjiashuEntity> {
	
	List<LaorenjiashuView> selectListView(@Param("ew") Wrapper<LaorenjiashuEntity> wrapper);

	List<LaorenjiashuView> selectListView(Pagination page,@Param("ew") Wrapper<LaorenjiashuEntity> wrapper);
	
	LaorenjiashuView selectView(@Param("ew") Wrapper<LaorenjiashuEntity> wrapper);
	

}
