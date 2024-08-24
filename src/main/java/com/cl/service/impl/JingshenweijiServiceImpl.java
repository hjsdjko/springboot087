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


import com.cl.dao.JingshenweijiDao;
import com.cl.entity.JingshenweijiEntity;
import com.cl.service.JingshenweijiService;
import com.cl.entity.view.JingshenweijiView;

@Service("jingshenweijiService")
public class JingshenweijiServiceImpl extends ServiceImpl<JingshenweijiDao, JingshenweijiEntity> implements JingshenweijiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingshenweijiEntity> page = this.selectPage(
                new Query<JingshenweijiEntity>(params).getPage(),
                new EntityWrapper<JingshenweijiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingshenweijiEntity> wrapper) {
		  Page<JingshenweijiView> page =new Query<JingshenweijiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JingshenweijiView> selectListView(Wrapper<JingshenweijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingshenweijiView selectView(Wrapper<JingshenweijiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
