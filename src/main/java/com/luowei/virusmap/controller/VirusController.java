package com.luowei.virusmap.controller;

import com.luowei.virusmap.domain.Incity;
import com.luowei.virusmap.service.VirusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className：
 * @Description：注释
 * @Author：罗威
 * @date：
 */
@RestController
@RequestMapping("/virus")
public class VirusController {
	Map<String,Object> resultMap=new HashMap<>();
	@Resource
	private VirusService virusService;

	@PostMapping("/in/list")
	public Map getIncityList(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer size
			,@RequestParam(defaultValue = "desc")String sort,@RequestParam(defaultValue = "id")String colum){
		List<Incity> list=virusService.getIncityList(page,size,sort,colum);
		resultMap.clear();
		resultMap.put("data",list);
		resultMap.put("code",200);
		return resultMap;
	}
}
