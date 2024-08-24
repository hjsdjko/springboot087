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


import com.cl.dao.YiliaobaojianshenqingDao;
import com.cl.entity.YiliaobaojianshenqingEntity;
import com.cl.service.YiliaobaojianshenqingService;
import com.cl.entity.view.YiliaobaojianshenqingView;

@Service("yiliaobaojianshenqingService")
public class YiliaobaojianshenqingServiceImpl extends ServiceImpl<YiliaobaojianshenqingDao, YiliaobaojianshenqingEntity> implements YiliaobaojianshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiliaobaojianshenqingEntity> page = this.selectPage(
                new Query<YiliaobaojianshenqingEntity>(params).getPage(),
                new EntityWrapper<YiliaobaojianshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiliaobaojianshenqingEntity> wrapper) {
		  Page<YiliaobaojianshenqingView> page =new Query<YiliaobaojianshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YiliaobaojianshenqingView> selectListView(Wrapper<YiliaobaojianshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiliaobaojianshenqingView selectView(Wrapper<YiliaobaojianshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
