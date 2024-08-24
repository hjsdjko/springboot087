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

import com.cl.entity.ShenghuofuwushenqingEntity;
import com.cl.entity.view.ShenghuofuwushenqingView;

import com.cl.service.ShenghuofuwushenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 生活服务申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/shenghuofuwushenqing")
public class ShenghuofuwushenqingController {
    @Autowired
    private ShenghuofuwushenqingService shenghuofuwushenqingService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenghuofuwushenqingEntity shenghuofuwushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			shenghuofuwushenqing.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("laorenjiashu")) {
			shenghuofuwushenqing.setJiashuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenghuofuwushenqingEntity> ew = new EntityWrapper<ShenghuofuwushenqingEntity>();

		PageUtils page = shenghuofuwushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenghuofuwushenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenghuofuwushenqingEntity shenghuofuwushenqing, 
		HttpServletRequest request){
        EntityWrapper<ShenghuofuwushenqingEntity> ew = new EntityWrapper<ShenghuofuwushenqingEntity>();

		PageUtils page = shenghuofuwushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenghuofuwushenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenghuofuwushenqingEntity shenghuofuwushenqing){
       	EntityWrapper<ShenghuofuwushenqingEntity> ew = new EntityWrapper<ShenghuofuwushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenghuofuwushenqing, "shenghuofuwushenqing")); 
        return R.ok().put("data", shenghuofuwushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenghuofuwushenqingEntity shenghuofuwushenqing){
        EntityWrapper< ShenghuofuwushenqingEntity> ew = new EntityWrapper< ShenghuofuwushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenghuofuwushenqing, "shenghuofuwushenqing")); 
		ShenghuofuwushenqingView shenghuofuwushenqingView =  shenghuofuwushenqingService.selectView(ew);
		return R.ok("查询生活服务申请成功").put("data", shenghuofuwushenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenghuofuwushenqingEntity shenghuofuwushenqing = shenghuofuwushenqingService.selectById(id);
		shenghuofuwushenqing = shenghuofuwushenqingService.selectView(new EntityWrapper<ShenghuofuwushenqingEntity>().eq("id", id));
        return R.ok().put("data", shenghuofuwushenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenghuofuwushenqingEntity shenghuofuwushenqing = shenghuofuwushenqingService.selectById(id);
		shenghuofuwushenqing = shenghuofuwushenqingService.selectView(new EntityWrapper<ShenghuofuwushenqingEntity>().eq("id", id));
        return R.ok().put("data", shenghuofuwushenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenghuofuwushenqingEntity shenghuofuwushenqing, HttpServletRequest request){
    	shenghuofuwushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenghuofuwushenqing);
        shenghuofuwushenqingService.insert(shenghuofuwushenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenghuofuwushenqingEntity shenghuofuwushenqing, HttpServletRequest request){
    	shenghuofuwushenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenghuofuwushenqing);
        shenghuofuwushenqingService.insert(shenghuofuwushenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShenghuofuwushenqingEntity shenghuofuwushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenghuofuwushenqing);
        shenghuofuwushenqingService.updateById(shenghuofuwushenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShenghuofuwushenqingEntity> list = new ArrayList<ShenghuofuwushenqingEntity>();
        for(Long id : ids) {
            ShenghuofuwushenqingEntity shenghuofuwushenqing = shenghuofuwushenqingService.selectById(id);
            shenghuofuwushenqing.setSfsh(sfsh);
            shenghuofuwushenqing.setShhf(shhf);
            list.add(shenghuofuwushenqing);
        }
        shenghuofuwushenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenghuofuwushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
