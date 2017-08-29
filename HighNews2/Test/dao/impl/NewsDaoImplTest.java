package dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.NewsBean;
import entity.NewstypeBean;

public class NewsDaoImplTest {

	@Test
	public void testDeleteNewsById() {
	/*	NewsBean newsBean=new NewsBean();
		newsBean.setNewsid(3);
		NewsDaoImpl newsDaoImpl=new NewsDaoImpl();
		newsDaoImpl.deleteNewsById(newsBean.getNewsid());*/
	}

	@Test
	public void testInsertNews() {
		/*	NewsDaoImpl newsDaoImpl=new NewsDaoImpl();
		NewstypeBean newstipeBean=new NewstypeBean();
		newstipeBean.setTypeid(1);
		
		NewsBean newsBean=new NewsBean();
	 newsBean.setAuthor("新建创建");
		newsBean.setNewsTypebean(newstipeBean);
		newsBean.setNewspic("sds2");
		newsBean.setContent("dsd发多少分大师傅sa6666");
		newsBean.setNewstitle("劳老师");
		newsBean.setPubtime("1032-12-19");
		
		boolean flag=newsDaoImpl.insertNews(newsBean);
		System.out.println("插入成功"+flag);*/
	}

	@Test
	public void testSelectNewsByIdInt() {
	/*	NewsDaoImpl newsDaoImpl=new NewsDaoImpl();
		NewsBean newsBean=new NewsBean();
		newsBean=newsDaoImpl.selectNewsById(1);
		System.out.println(newsBean);*/
	}

	@Test
	public void testSelectNewsByIdString() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateNews() {
		NewsDaoImpl newsDaoImpl=new NewsDaoImpl();
		NewsBean newsBean=new NewsBean();
		newsBean.setNewsid(4);
	//	newsBean.setTypeid(1);
		
		NewstypeBean  newsTypebean=new NewstypeBean();
		newsTypebean.setTypeid(1);
		
		newsBean.setNewsTypebean(newsTypebean);
		newsBean.setAuthor("阿狸");
		
		newsBean.setNewspic("sds");
		newsBean.setContent("哈哈哈哈");
		newsBean.setNewstitle("劳老师的啊啊啊");
		newsBean.setPubtime("1032-12-19");
		
		boolean flag=newsDaoImpl.updateNews(newsBean);
		System.out.println("修改成功"+flag);
	}

	@Test
	public void testMain() {
		//fail("Not yet implemented");
	}

}
