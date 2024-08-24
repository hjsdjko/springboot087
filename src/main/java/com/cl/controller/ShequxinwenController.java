package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ShequxinwenEntity;
import com.cl.entity.view.ShequxinwenView;

import com.cl.service.ShequxinwenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 社区新闻
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/shequxinwen")
public class ShequxinwenController {
    @Autowired
    private ShequxinwenService shequxinwenService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShequxinwenEntity shequxinwen,
		HttpServletRequest request){
        EntityWrapper<ShequxinwenEntity> ew = new EntityWrapper<ShequxinwenEntity>();

		PageUtils page = shequxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequxinwen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShequxinwenEntity shequxinwen, 
		HttpServletRequest request){
        EntityWrapper<ShequxinwenEntity> ew = new EntityWrapper<ShequxinwenEntity>();

		PageUtils page = shequxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequxinwen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShequxinwenEntity shequxinwen){
       	EntityWrapper<ShequxinwenEntity> ew = new EntityWrapper<ShequxinwenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shequxinwen, "shequxinwen")); 
        return R.ok().put("data", shequxinwenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShequxinwenEntity shequxinwen){
        EntityWrapper< ShequxinwenEntity> ew = new EntityWrapper< ShequxinwenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shequxinwen, "shequxinwen")); 
		ShequxinwenView shequxinwenView =  shequxinwenService.selectView(ew);
		return R.ok("查询社区新闻成功").put("data", shequxinwenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShequxinwenEntity shequxinwen = shequxinwenService.selectById(id);
		shequxinwen = shequxinwenService.selectView(new EntityWrapper<ShequxinwenEntity>().eq("id", id));
        return R.ok().put("data", shequxinwen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShequxinwenEntity shequxinwen = shequxinwenService.selectById(id);
		shequxinwen = shequxinwenService.selectView(new EntityWrapper<ShequxinwenEntity>().eq("id", id));
        return R.ok().put("data", shequxinwen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShequxinwenEntity shequxinwen, HttpServletRequest request){
    	shequxinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shequxinwen);
        shequxinwenService.insert(shequxinwen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShequxinwenEntity shequxinwen, HttpServletRequest request){
    	shequxinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shequxinwen);
        shequxinwenService.insert(shequxinwen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShequxinwenEntity shequxinwen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shequxinwen);
        shequxinwenService.updateById(shequxinwen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shequxinwenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
