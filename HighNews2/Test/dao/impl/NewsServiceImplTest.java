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
	public void testRemoveNewsById() {//���Գɹ�
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
		newsBean.setAuthor("�޸���Ϣ���ߣ�ɾ����iddddddd");
		
		newsBean.setNewspic("�޸���id");
		newsBean.setContent("�޸���id���ܷ����������");
		newsBean.setNewstitle("����ʦ");
		newsBean.setPubtime("1032-12-19");	
		NewsServiceImpl newsServiceImpl=new NewsServiceImpl();
		boolean flag=newsServiceImpl.changeNews(newsBean);
		System.out.println("�޸ĳɹ�"+flag);
	}

}
