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


import com.cl.dao.LeixingDao;
import com.cl.entity.LeixingEntity;
import com.cl.service.LeixingService;
import com.cl.entity.view.LeixingView;

@Service("leixingService")
public class LeixingServiceImpl extends ServiceImpl<LeixingDao, LeixingEntity> implements LeixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LeixingEntity> page = this.selectPage(
                new Query<LeixingEntity>(params).getPage(),
                new EntityWrapper<LeixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LeixingEntity> wrapper) {
		  Page<LeixingView> page =new Query<LeixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LeixingView> selectListView(Wrapper<LeixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LeixingView selectView(Wrapper<LeixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
