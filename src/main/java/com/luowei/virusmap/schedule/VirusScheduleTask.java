package com.luowei.virusmap.schedule;

import com.luowei.virusmap.processor.VirusProcessor;
import com.luowei.virusmap.processor.VirusProvinceProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import us.codecraft.webmagic.Spider;

/**
 * @className：
 * @Description：注释
 * @Author：罗威
 * @date：
 */
@EnableScheduling
@Configuration
public class VirusScheduleTask {
	@Scheduled(cron = "0/60 * * * * ?")
	private void starToGet(){
		Spider.create(new VirusProcessor()).addUrl("https://huiyan.baidu.com/openapi/v1/migration/rank?type=move&ak=kgD2HiDnLdUhwzd3CLuG5AWNfX3fhLYe&adminTy").thread(1).run();
	}
	@Scheduled(cron = "0/60 * * * * ?")
	private void starToGetVirusData(){
		Spider.create(new VirusProvinceProcessor()).addUrl("https://c.m.163.com/ug/api/wuhan/app/index/feiyan-data-list?t=1581075467885").thread(1).run();
	}
}
