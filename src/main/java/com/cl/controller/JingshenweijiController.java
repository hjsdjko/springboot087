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

import com.cl.entity.JingshenweijiEntity;
import com.cl.entity.view.JingshenweijiView;

import com.cl.service.JingshenweijiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 精神慰籍
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/jingshenweiji")
public class JingshenweijiController {
    @Autowired
    private JingshenweijiService jingshenweijiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingshenweijiEntity jingshenweiji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			jingshenweiji.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("laorenjiashu")) {
			jingshenweiji.setJiashuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingshenweijiEntity> ew = new EntityWrapper<JingshenweijiEntity>();

		PageUtils page = jingshenweijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingshenweiji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingshenweijiEntity jingshenweiji, 
		HttpServletRequest request){
        EntityWrapper<JingshenweijiEntity> ew = new EntityWrapper<JingshenweijiEntity>();

		PageUtils page = jingshenweijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingshenweiji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingshenweijiEntity jingshenweiji){
       	EntityWrapper<JingshenweijiEntity> ew = new EntityWrapper<JingshenweijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingshenweiji, "jingshenweiji")); 
        return R.ok().put("data", jingshenweijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingshenweijiEntity jingshenweiji){
        EntityWrapper< JingshenweijiEntity> ew = new EntityWrapper< JingshenweijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingshenweiji, "jingshenweiji")); 
		JingshenweijiView jingshenweijiView =  jingshenweijiService.selectView(ew);
		return R.ok("查询精神慰籍成功").put("data", jingshenweijiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingshenweijiEntity jingshenweiji = jingshenweijiService.selectById(id);
		jingshenweiji = jingshenweijiService.selectView(new EntityWrapper<JingshenweijiEntity>().eq("id", id));
        return R.ok().put("data", jingshenweiji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingshenweijiEntity jingshenweiji = jingshenweijiService.selectById(id);
		jingshenweiji = jingshenweijiService.selectView(new EntityWrapper<JingshenweijiEntity>().eq("id", id));
        return R.ok().put("data", jingshenweiji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingshenweijiEntity jingshenweiji, HttpServletRequest request){
    	jingshenweiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingshenweiji);
        jingshenweijiService.insert(jingshenweiji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingshenweijiEntity jingshenweiji, HttpServletRequest request){
    	jingshenweiji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingshenweiji);
        jingshenweijiService.insert(jingshenweiji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingshenweijiEntity jingshenweiji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingshenweiji);
        jingshenweijiService.updateById(jingshenweiji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingshenweijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
