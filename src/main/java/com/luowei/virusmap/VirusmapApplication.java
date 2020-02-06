package com.luowei.virusmap;

import com.luowei.virusmap.processor.VirusProcessor;
import com.luowei.virusmap.utils.ApplicationUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import us.codecraft.webmagic.Spider;

@SpringBootApplication(scanBasePackages = {"com.luowei.virusmap"})
@MapperScan("com.luowei.virusmap.dao")
public class VirusmapApplication {
	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(VirusmapApplication.class, args);

	}

}
