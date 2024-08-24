package com.cl.dao;

import com.cl.entity.ShequxinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShequxinwenView;


/**
 * 社区新闻
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface ShequxinwenDao extends BaseMapper<ShequxinwenEntity> {
	
	List<ShequxinwenView> selectListView(@Param("ew") Wrapper<ShequxinwenEntity> wrapper);

	List<ShequxinwenView> selectListView(Pagination page,@Param("ew") Wrapper<ShequxinwenEntity> wrapper);
	
	ShequxinwenView selectView(@Param("ew") Wrapper<ShequxinwenEntity> wrapper);
	

}
