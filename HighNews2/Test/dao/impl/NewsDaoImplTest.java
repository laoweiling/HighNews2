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
	 newsBean.setAuthor("�½�����");
		newsBean.setNewsTypebean(newstipeBean);
		newsBean.setNewspic("sds2");
		newsBean.setContent("dsd�����ٷִ�ʦ��sa6666");
		newsBean.setNewstitle("����ʦ");
		newsBean.setPubtime("1032-12-19");
		
		boolean flag=newsDaoImpl.insertNews(newsBean);
		System.out.println("����ɹ�"+flag);*/
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
		newsBean.setAuthor("����");
		
		newsBean.setNewspic("sds");
		newsBean.setContent("��������");
		newsBean.setNewstitle("����ʦ�İ�����");
		newsBean.setPubtime("1032-12-19");
		
		boolean flag=newsDaoImpl.updateNews(newsBean);
		System.out.println("�޸ĳɹ�"+flag);
	}

	@Test
	public void testMain() {
		//fail("Not yet implemented");
	}

}
