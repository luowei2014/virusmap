package com.luowei.virusmap.processor;

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
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	@Override
	public void process(Page page) {
		String htmlcontent=page.getHtml().toString();
		System.out.println(page.getHtml().toString());
		List<Selectable> trList= page.getHtml().xpath("//table[@class='VirusTable_1-1-113_38pQEh']/tbody").nodes();
		for(Selectable selectable:trList){
			String province=selectable.xpath("//div[@class='VirusTable_1-1-113_AcDK7v']/span").nodes().get(1).toString();
			selectable.xpath("//");
		}
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args){
		Spider.create(new VirusProvinceProcessor()).addUrl("https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_pc_3#tab1").thread(1).run();
	}
}
