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

import com.cl.entity.BaojianleixingEntity;
import com.cl.entity.view.BaojianleixingView;

import com.cl.service.BaojianleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 保健类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/baojianleixing")
public class BaojianleixingController {
    @Autowired
    private BaojianleixingService baojianleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaojianleixingEntity baojianleixing,
		HttpServletRequest request){
        EntityWrapper<BaojianleixingEntity> ew = new EntityWrapper<BaojianleixingEntity>();

		PageUtils page = baojianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baojianleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaojianleixingEntity baojianleixing, 
		HttpServletRequest request){
        EntityWrapper<BaojianleixingEntity> ew = new EntityWrapper<BaojianleixingEntity>();

		PageUtils page = baojianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baojianleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaojianleixingEntity baojianleixing){
       	EntityWrapper<BaojianleixingEntity> ew = new EntityWrapper<BaojianleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baojianleixing, "baojianleixing")); 
        return R.ok().put("data", baojianleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaojianleixingEntity baojianleixing){
        EntityWrapper< BaojianleixingEntity> ew = new EntityWrapper< BaojianleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baojianleixing, "baojianleixing")); 
		BaojianleixingView baojianleixingView =  baojianleixingService.selectView(ew);
		return R.ok("查询保健类型成功").put("data", baojianleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaojianleixingEntity baojianleixing = baojianleixingService.selectById(id);
		baojianleixing = baojianleixingService.selectView(new EntityWrapper<BaojianleixingEntity>().eq("id", id));
        return R.ok().put("data", baojianleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaojianleixingEntity baojianleixing = baojianleixingService.selectById(id);
		baojianleixing = baojianleixingService.selectView(new EntityWrapper<BaojianleixingEntity>().eq("id", id));
        return R.ok().put("data", baojianleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaojianleixingEntity baojianleixing, HttpServletRequest request){
    	baojianleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baojianleixing);
        baojianleixingService.insert(baojianleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaojianleixingEntity baojianleixing, HttpServletRequest request){
    	baojianleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baojianleixing);
        baojianleixingService.insert(baojianleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody BaojianleixingEntity baojianleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baojianleixing);
        baojianleixingService.updateById(baojianleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baojianleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
