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


import com.cl.dao.BaojianleixingDao;
import com.cl.entity.BaojianleixingEntity;
import com.cl.service.BaojianleixingService;
import com.cl.entity.view.BaojianleixingView;

@Service("baojianleixingService")
public class BaojianleixingServiceImpl extends ServiceImpl<BaojianleixingDao, BaojianleixingEntity> implements BaojianleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaojianleixingEntity> page = this.selectPage(
                new Query<BaojianleixingEntity>(params).getPage(),
                new EntityWrapper<BaojianleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaojianleixingEntity> wrapper) {
		  Page<BaojianleixingView> page =new Query<BaojianleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<BaojianleixingView> selectListView(Wrapper<BaojianleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaojianleixingView selectView(Wrapper<BaojianleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
