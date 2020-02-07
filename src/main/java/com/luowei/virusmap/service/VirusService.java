package com.luowei.virusmap.service;

import com.github.pagehelper.PageHelper;
import com.luowei.virusmap.dao.IncityMapper;
import com.luowei.virusmap.dao.OutcityMapper;
import com.luowei.virusmap.dao.VirusdataMapper;
import com.luowei.virusmap.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className：
 * @Description：注释
 * @Author：罗威
 * @date：
 */
@Component
public class VirusService {
	@Resource
	private IncityMapper incityMapper;
	@Resource
	private OutcityMapper outcityMapper;
	@Resource
	private VirusdataMapper virusdataMapper;

	public List<Virusdata> getVirusDataList(int page,int size,String sort,String sortColum){
		PageHelper.startPage(page, size);
		VirusdataExample virusdataExample=new VirusdataExample();
		VirusdataExample.Criteria criteria=virusdataExample.createCriteria();
		virusdataExample.setOrderByClause(sortColum+" "+sort);
		return virusdataMapper.selectByExample(virusdataExample);
	}
	public Incity getByCity(String cityCode){
		IncityExample incityExample=new IncityExample();
		IncityExample.Criteria criteria=incityExample.createCriteria();
		criteria.andCityCodeEqualTo(cityCode);
		return incityMapper.selectOneByExample(incityExample);
	}

	public List<Incity> getIncityList(int page,int size,String sort,String sortColum){
		PageHelper.startPage(page, size);
		IncityExample incityExample=new IncityExample();
		IncityExample.Criteria criteria=incityExample.createCriteria();
		incityExample.setOrderByClause(sortColum+" "+sort);
		return incityMapper.selectByExample(incityExample);
	}

	public Outcity getByOutCity(String cityCode){
		OutcityExample outcityExample=new OutcityExample();
		OutcityExample.Criteria criteria=outcityExample.createCriteria();
		criteria.andCityCodeEqualTo(cityCode);
		return outcityMapper.selectOneByExample(outcityExample);
	}

	public List<Outcity> getOutcityList(int page,int size,String sort,String sortColum){
		PageHelper.startPage(page, size);
		OutcityExample outcityExample=new OutcityExample();
		OutcityExample.Criteria criteria=outcityExample.createCriteria();
		outcityExample.setOrderByClause(sortColum+" "+sort);
		return outcityMapper.selectByExample(outcityExample);
	}
}
