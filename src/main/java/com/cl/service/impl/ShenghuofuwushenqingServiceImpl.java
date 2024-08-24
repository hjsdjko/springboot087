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


import com.cl.dao.ShenghuofuwushenqingDao;
import com.cl.entity.ShenghuofuwushenqingEntity;
import com.cl.service.ShenghuofuwushenqingService;
import com.cl.entity.view.ShenghuofuwushenqingView;

@Service("shenghuofuwushenqingService")
public class ShenghuofuwushenqingServiceImpl extends ServiceImpl<ShenghuofuwushenqingDao, ShenghuofuwushenqingEntity> implements ShenghuofuwushenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenghuofuwushenqingEntity> page = this.selectPage(
                new Query<ShenghuofuwushenqingEntity>(params).getPage(),
                new EntityWrapper<ShenghuofuwushenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenghuofuwushenqingEntity> wrapper) {
		  Page<ShenghuofuwushenqingView> page =new Query<ShenghuofuwushenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShenghuofuwushenqingView> selectListView(Wrapper<ShenghuofuwushenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenghuofuwushenqingView selectView(Wrapper<ShenghuofuwushenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
