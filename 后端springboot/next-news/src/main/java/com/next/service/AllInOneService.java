package com.next.service;

import java.util.List;

import com.next.pojo.News;
import com.next.pojo.Type;

public interface AllInOneService {

	/**
	 * @Description: 查询所有分类名称
	 */
	public List<Type> queryAllTypes();
	
	/**
	 * @Description: 根据分类查询新闻列表
	 */
	public List<News> queryAllNewsListByType(String typeId);
	
	/**
	 * @Description: 根据新闻id查询指定的新闻内容详情
	 */
	public News queryNewsDetail(String newsId);
	
}
