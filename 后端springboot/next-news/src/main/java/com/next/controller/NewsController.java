package com.next.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.next.pojo.News;
import com.next.service.AllInOneService;
import com.next.utils.NEXTJSONResult;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private AllInOneService allInOneService;
	
	@GetMapping("/list")
	@ResponseBody
	public NEXTJSONResult list(String typeId) {
		List<News> newsList = allInOneService.queryAllNewsListByType(typeId);
		return NEXTJSONResult.ok(newsList);
	}
	
	@GetMapping("/detail")
	@ResponseBody
	public NEXTJSONResult detail(String newsId) {
		News detail = allInOneService.queryNewsDetail(newsId);
		System.out.println(newsId);
		return NEXTJSONResult.ok(detail);
	}
	
}
