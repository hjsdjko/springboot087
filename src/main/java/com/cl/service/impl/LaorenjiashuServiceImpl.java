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


import com.cl.dao.LaorenjiashuDao;
import com.cl.entity.LaorenjiashuEntity;
import com.cl.service.LaorenjiashuService;
import com.cl.entity.view.LaorenjiashuView;

@Service("laorenjiashuService")
public class LaorenjiashuServiceImpl extends ServiceImpl<LaorenjiashuDao, LaorenjiashuEntity> implements LaorenjiashuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaorenjiashuEntity> page = this.selectPage(
                new Query<LaorenjiashuEntity>(params).getPage(),
                new EntityWrapper<LaorenjiashuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaorenjiashuEntity> wrapper) {
		  Page<LaorenjiashuView> page =new Query<LaorenjiashuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LaorenjiashuView> selectListView(Wrapper<LaorenjiashuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaorenjiashuView selectView(Wrapper<LaorenjiashuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
