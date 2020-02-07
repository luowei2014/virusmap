package com.luowei.virusmap.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luowei.virusmap.dao.IncityMapper;
import com.luowei.virusmap.dao.VirusdataMapper;
import com.luowei.virusmap.domain.Incity;
import com.luowei.virusmap.domain.IncityExample;
import com.luowei.virusmap.domain.Virusdata;
import com.luowei.virusmap.domain.VirusdataExample;
import com.luowei.virusmap.utils.ApplicationUtil;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @className：
 * @Description：注释
 * @Author：罗威
 * @date：
 */
public class VirusProvinceProcessor implements PageProcessor {
	private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);
	private VirusdataMapper virusdataMapper;
	@Override
	public void process(Page page) {
		virusdataMapper= (VirusdataMapper) ApplicationUtil.getBean("virusdataMapper");
		String jsonStr=page.getRawText();
		JSONObject jsonObject= JSON.parseObject(jsonStr);
		JSONObject resultJSON=jsonObject.getJSONObject("data");
		JSONArray dataList=resultJSON.getJSONArray("list");

		for(int i=0;i<dataList.size();i++){
			Virusdata virusdata=new Virusdata();
			JSONObject data=dataList.getJSONObject(i);
			String name=data.getString("name");
			String province=data.getString("province");
			Integer confirm=data.getInteger("confirm");
			Integer suspect=data.getInteger("suspect");
			Integer heal=data.getInteger("heal");
			Integer dead=data.getInteger("dead");
			virusdata.setDead(dead);
			virusdata.setConfirm(confirm);
			virusdata.setHeal(heal);
			virusdata.setName(name);
			virusdata.setProvince(province);
			virusdata.setSuspect(suspect);

			VirusdataExample virusdataExample=new VirusdataExample();
			VirusdataExample.Criteria criteria=virusdataExample.createCriteria();
			criteria.andNameEqualTo(virusdata.getName());
			Virusdata virusdata1=virusdataMapper.selectOneByExample(virusdataExample);
			try{
				if(null==virusdata1){
					virusdataMapper.insert(virusdata);
				}else {
					virusdata1.setSuspect(virusdata.getSuspect());
					virusdata1.setHeal(virusdata.getHeal());
					virusdata1.setDead(virusdata.getDead());
					virusdata1.setConfirm(virusdata.getConfirm());
					virusdataMapper.updateByPrimaryKey(virusdata1);
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


}
