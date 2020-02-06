package com.luowei.virusmap.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luowei.virusmap.dao.IncityMapper;
import com.luowei.virusmap.dao.OutcityMapper;
import com.luowei.virusmap.domain.Incity;
import com.luowei.virusmap.domain.IncityExample;
import com.luowei.virusmap.domain.Outcity;
import com.luowei.virusmap.domain.OutcityExample;
import com.luowei.virusmap.utils.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @className：
 * @Description：注释
 * @Author：罗威
 * @date：
 */
@Service
public class VirusProcessor implements PageProcessor {
	private IncityMapper incityMapper;
	private OutcityMapper outcityMapper;
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	@Override
	public void process(Page page) {
		incityMapper= (IncityMapper)ApplicationUtil.getBean("incityMapper");
		outcityMapper= (OutcityMapper)ApplicationUtil.getBean("outcityMapper");
		String jsonStr=page.getRawText();
		JSONObject jsonObject= JSON.parseObject(jsonStr);
		JSONObject resultJSON=jsonObject.getJSONObject("result");
		JSONArray inList=resultJSON.getJSONArray("moveInList");
		JSONArray outList=resultJSON.getJSONArray("moveOutList");

		for(int i=0;i<inList.size();i++){
			JSONObject jsonObject1=inList.getJSONObject(i);
			Incity incity=new Incity();
			incity.setCityCode(jsonObject1.getString("city_code"));
			incity.setCityName(jsonObject1.getString("city_name"));
			incity.setProvinceName(jsonObject1.getString("province_name"));
			incity.setValue(jsonObject1.getDouble("value"));
			incity.setAddTime(LocalDateTime.now());
			incity.setUpdateTime(LocalDateTime.now());
			IncityExample incityExample=new IncityExample();
			IncityExample.Criteria criteria=incityExample.createCriteria();
			criteria.andCityCodeEqualTo(incity.getCityCode());
			Incity databaseIncity=incityMapper.selectOneByExample(incityExample);
			try{
				if(null==databaseIncity){
					incityMapper.insert(incity);
				}else {
					if(databaseIncity.getValue()!=incity.getValue()){
						databaseIncity.setValue(incity.getValue());
						incityMapper.updateByPrimaryKey(databaseIncity);
					}

				}

			}catch (Exception e){
				e.printStackTrace();

			}
		}
		for(int i=0;i<outList.size();i++){
			JSONObject jsonObject1=outList.getJSONObject(i);
			Outcity outcity=new Outcity();
			outcity.setCityCode(jsonObject1.getString("city_code"));
			outcity.setCityName(jsonObject1.getString("city_name"));
			outcity.setProvinceName(jsonObject1.getString("province_name"));
			outcity.setValue(jsonObject1.getDouble("value"));
			outcity.setAddTime(LocalDateTime.now());
			outcity.setUpdateTime(LocalDateTime.now());
			OutcityExample outcityExample=new OutcityExample();
			OutcityExample.Criteria criteria=outcityExample.createCriteria();
			criteria.andCityCodeEqualTo(outcity.getCityCode());
			Outcity databaseOutcity=outcityMapper.selectOneByExample(outcityExample);
			try{
				if(null==databaseOutcity){
					outcityMapper.insert(outcity);
				}else {
					if(databaseOutcity.getValue()!=outcity.getValue()){
						databaseOutcity.setValue(outcity.getValue());
						outcityMapper.updateByPrimaryKey(outcity);
					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {

	}


}
