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


import com.cl.dao.ShequxinwenDao;
import com.cl.entity.ShequxinwenEntity;
import com.cl.service.ShequxinwenService;
import com.cl.entity.view.ShequxinwenView;

@Service("shequxinwenService")
public class ShequxinwenServiceImpl extends ServiceImpl<ShequxinwenDao, ShequxinwenEntity> implements ShequxinwenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShequxinwenEntity> page = this.selectPage(
                new Query<ShequxinwenEntity>(params).getPage(),
                new EntityWrapper<ShequxinwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShequxinwenEntity> wrapper) {
		  Page<ShequxinwenView> page =new Query<ShequxinwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShequxinwenView> selectListView(Wrapper<ShequxinwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShequxinwenView selectView(Wrapper<ShequxinwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
