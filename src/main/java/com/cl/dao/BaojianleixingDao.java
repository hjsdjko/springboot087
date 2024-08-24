package com.cl.dao;

import com.cl.entity.BaojianleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.BaojianleixingView;


/**
 * 保健类型
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface BaojianleixingDao extends BaseMapper<BaojianleixingEntity> {
	
	List<BaojianleixingView> selectListView(@Param("ew") Wrapper<BaojianleixingEntity> wrapper);

	List<BaojianleixingView> selectListView(Pagination page,@Param("ew") Wrapper<BaojianleixingEntity> wrapper);
	
	BaojianleixingView selectView(@Param("ew") Wrapper<BaojianleixingEntity> wrapper);
	

}
