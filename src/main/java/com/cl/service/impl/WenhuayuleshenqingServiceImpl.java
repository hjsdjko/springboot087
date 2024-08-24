package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.WenhuayuleshenqingDao;
import com.cl.entity.WenhuayuleshenqingEntity;
import com.cl.service.WenhuayuleshenqingService;
import com.cl.entity.view.WenhuayuleshenqingView;

@Service("wenhuayuleshenqingService")
public class WenhuayuleshenqingServiceImpl extends ServiceImpl<WenhuayuleshenqingDao, WenhuayuleshenqingEntity> implements WenhuayuleshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenhuayuleshenqingEntity> page = this.selectPage(
                new Query<WenhuayuleshenqingEntity>(params).getPage(),
                new EntityWrapper<WenhuayuleshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenhuayuleshenqingEntity> wrapper) {
		  Page<WenhuayuleshenqingView> page =new Query<WenhuayuleshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WenhuayuleshenqingView> selectListView(Wrapper<WenhuayuleshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenhuayuleshenqingView selectView(Wrapper<WenhuayuleshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
