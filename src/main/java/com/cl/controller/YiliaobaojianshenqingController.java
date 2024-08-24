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

import com.cl.entity.YiliaobaojianshenqingEntity;
import com.cl.entity.view.YiliaobaojianshenqingView;

import com.cl.service.YiliaobaojianshenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 医疗保健申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-05 19:14:13
 */
@RestController
@RequestMapping("/yiliaobaojianshenqing")
public class YiliaobaojianshenqingController {
    @Autowired
    private YiliaobaojianshenqingService yiliaobaojianshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YiliaobaojianshenqingEntity yiliaobaojianshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoren")) {
			yiliaobaojianshenqing.setLaorenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("laorenjiashu")) {
			yiliaobaojianshenqing.setJiashuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YiliaobaojianshenqingEntity> ew = new EntityWrapper<YiliaobaojianshenqingEntity>();

		PageUtils page = yiliaobaojianshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaobaojianshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YiliaobaojianshenqingEntity yiliaobaojianshenqing, 
		HttpServletRequest request){
        EntityWrapper<YiliaobaojianshenqingEntity> ew = new EntityWrapper<YiliaobaojianshenqingEntity>();

		PageUtils page = yiliaobaojianshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yiliaobaojianshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YiliaobaojianshenqingEntity yiliaobaojianshenqing){
       	EntityWrapper<YiliaobaojianshenqingEntity> ew = new EntityWrapper<YiliaobaojianshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yiliaobaojianshenqing, "yiliaobaojianshenqing")); 
        return R.ok().put("data", yiliaobaojianshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YiliaobaojianshenqingEntity yiliaobaojianshenqing){
        EntityWrapper< YiliaobaojianshenqingEntity> ew = new EntityWrapper< YiliaobaojianshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yiliaobaojianshenqing, "yiliaobaojianshenqing")); 
		YiliaobaojianshenqingView yiliaobaojianshenqingView =  yiliaobaojianshenqingService.selectView(ew);
		return R.ok("查询医疗保健申请成功").put("data", yiliaobaojianshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YiliaobaojianshenqingEntity yiliaobaojianshenqing = yiliaobaojianshenqingService.selectById(id);
		yiliaobaojianshenqing = yiliaobaojianshenqingService.selectView(new EntityWrapper<YiliaobaojianshenqingEntity>().eq("id", id));
        return R.ok().put("data", yiliaobaojianshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YiliaobaojianshenqingEntity yiliaobaojianshenqing = yiliaobaojianshenqingService.selectById(id);
		yiliaobaojianshenqing = yiliaobaojianshenqingService.selectView(new EntityWrapper<YiliaobaojianshenqingEntity>().eq("id", id));
        return R.ok().put("data", yiliaobaojianshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YiliaobaojianshenqingEntity yiliaobaojianshenqing, HttpServletRequest request){
    	yiliaobaojianshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiliaobaojianshenqing);
        yiliaobaojianshenqingService.insert(yiliaobaojianshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YiliaobaojianshenqingEntity yiliaobaojianshenqing, HttpServletRequest request){
    	yiliaobaojianshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yiliaobaojianshenqing);
        yiliaobaojianshenqingService.insert(yiliaobaojianshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YiliaobaojianshenqingEntity yiliaobaojianshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yiliaobaojianshenqing);
        yiliaobaojianshenqingService.updateById(yiliaobaojianshenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YiliaobaojianshenqingEntity> list = new ArrayList<YiliaobaojianshenqingEntity>();
        for(Long id : ids) {
            YiliaobaojianshenqingEntity yiliaobaojianshenqing = yiliaobaojianshenqingService.selectById(id);
            yiliaobaojianshenqing.setSfsh(sfsh);
            yiliaobaojianshenqing.setShhf(shhf);
            list.add(yiliaobaojianshenqing);
        }
        yiliaobaojianshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yiliaobaojianshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
