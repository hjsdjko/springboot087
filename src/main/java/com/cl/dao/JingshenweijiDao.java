package com.cl.dao;

import com.cl.entity.JingshenweijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingshenweijiView;


/**
 * 精神慰籍
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface JingshenweijiDao extends BaseMapper<JingshenweijiEntity> {
	
	List<JingshenweijiView> selectListView(@Param("ew") Wrapper<JingshenweijiEntity> wrapper);

	List<JingshenweijiView> selectListView(Pagination page,@Param("ew") Wrapper<JingshenweijiEntity> wrapper);
	
	JingshenweijiView selectView(@Param("ew") Wrapper<JingshenweijiEntity> wrapper);
	

}
