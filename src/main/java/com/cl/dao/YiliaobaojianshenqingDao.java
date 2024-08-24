package com.cl.dao;

import com.cl.entity.YiliaobaojianshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YiliaobaojianshenqingView;


/**
 * 医疗保健申请
 * 
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
public interface YiliaobaojianshenqingDao extends BaseMapper<YiliaobaojianshenqingEntity> {
	
	List<YiliaobaojianshenqingView> selectListView(@Param("ew") Wrapper<YiliaobaojianshenqingEntity> wrapper);

	List<YiliaobaojianshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<YiliaobaojianshenqingEntity> wrapper);
	
	YiliaobaojianshenqingView selectView(@Param("ew") Wrapper<YiliaobaojianshenqingEntity> wrapper);
	

}
