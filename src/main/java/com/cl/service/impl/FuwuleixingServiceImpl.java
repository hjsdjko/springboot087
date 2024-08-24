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


import com.cl.dao.FuwuleixingDao;
import com.cl.entity.FuwuleixingEntity;
import com.cl.service.FuwuleixingService;
import com.cl.entity.view.FuwuleixingView;

@Service("fuwuleixingService")
public class FuwuleixingServiceImpl extends ServiceImpl<FuwuleixingDao, FuwuleixingEntity> implements FuwuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuleixingEntity> page = this.selectPage(
                new Query<FuwuleixingEntity>(params).getPage(),
                new EntityWrapper<FuwuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuleixingEntity> wrapper) {
		  Page<FuwuleixingView> page =new Query<FuwuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FuwuleixingView> selectListView(Wrapper<FuwuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuleixingView selectView(Wrapper<FuwuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
