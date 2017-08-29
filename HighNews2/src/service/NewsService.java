package service;

import java.util.List;

import entity.NewsBean;
/*模块：新闻业务逻辑层处理
 * 组员：黄卉、劳伟玲
 * 日期：2017年1月11日组合终结
 * 类名：NewsService接口
 * 任务：
 * （一）黄卉：实现删除新闻、修改新闻业务逻辑处理接口
 * （二）劳伟玲： 实现添加新闻接口、查询新闻接口、分页接口业务逻辑
 * 方法
 * （1）新闻信息删除、修改方法
 * （2）添加新闻、查询新闻方法
 * */
public interface NewsService {
	  //根据新闻id查找单条信息//按类型号查找（传id）
	 public NewsBean getNewsById(int _id);  
	 //查全部新闻信息
	 public List<NewsBean> getNews(String select_); 
	 //添加新闻信息（传实体类对象）
	 public   boolean  addnews(NewsBean r); 
	 //删除新闻信息（根据id）
	 public   boolean  removeNewsById(int _id);  
	 //修改新闻信息（根据对象传参）
	 public   boolean  changeNews(NewsBean r);   
}
