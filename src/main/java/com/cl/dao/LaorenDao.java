package com.cl.dao;

import com.cl.entity.LaorenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LaorenView;


/**
 * 老人
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:12
 */
public interface LaorenDao extends BaseMapper<LaorenEntity> {
	
	List<LaorenView> selectListView(@Param("ew") Wrapper<LaorenEntity> wrapper);

	List<LaorenView> selectListView(Pagination page,@Param("ew") Wrapper<LaorenEntity> wrapper);
	
	LaorenView selectView(@Param("ew") Wrapper<LaorenEntity> wrapper);
	

}
