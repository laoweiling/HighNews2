package dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.NewsBean;
import entity.NewstypeBean;

import service.NewsService;
import service.impl.NewsServiceImpl;

public class NewsServiceImplTest {

	@Test
	public void testGetNewsById() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testGetNews() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testAddNews() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testRemoveNewsById() {//测试成功
		/*
		NewsService newsServiceImpl=new NewsServiceImpl();
		boolean flag=newsServiceImpl.removeNewsById(6);
		System.out.println("flag:"+flag);
	*/
	}

	@Test
	public void testChangeNews() {
		NewsBean newsBean=new NewsBean();
		
		NewstypeBean  newsTypebean=new NewstypeBean();
		newsTypebean.setTypeid(1);	
		newsBean.setNewsTypebean(newsTypebean);
		
		newsBean.setNewsid(7);
		newsBean.setAuthor("修改信息作者，删除了iddddddd");
		
		newsBean.setNewspic("修改了id");
		newsBean.setContent("修改了id冯绍峰等所发生的");
		newsBean.setNewstitle("劳老师");
		newsBean.setPubtime("1032-12-19");	
		NewsServiceImpl newsServiceImpl=new NewsServiceImpl();
		boolean flag=newsServiceImpl.changeNews(newsBean);
		System.out.println("修改成功"+flag);
	}

}
