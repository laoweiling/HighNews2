package service.impl;

import java.util.List;
import java.util.Vector;

import org.hibernate.Transaction;
import org.hibernate.Session;   //要这个表，不属于hibernate，需要

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import service.NewsService;
import util.HibernateSessionFactory;
import entity.NewsBean;
/*模块：新闻业务逻辑层处理
 * 组员：黄卉、劳伟玲
 * 日期：2017年1月11日组合终结
 * 类名：NewsService接口实现类
 * 任务：
 * （一）黄卉：实现删除新闻、修改新闻业务逻辑处理接口
 * （二）劳伟玲： 实现添加新闻接口、查询新闻接口、分页接口业务逻辑
 * 方法
 * （1）新闻信息删除、修改方法
 * （2）添加新闻、查询新闻方法
 * */
public class NewsServiceImpl implements NewsService, java.io.Serializable{
	Session session;
	boolean flag=false;
	private NewsDao newsDao = new NewsDaoImpl();
	@Override
	 //根据新闻id查找单条信息//按类型号查找（传id）
	public NewsBean getNewsById(int _id) {
		NewsBean news = newsDao.selectNewsById(_id);
		//关闭session
		HibernateSessionFactory.getSession().close();
		return news;		
	}	
	/*  
	 //huanghuai方法二：
	@Override
	public NewsBean getNewsById(int _id) {
		NewsDao newsDaoimpl=new NewsDaoImpl();
		NewsBean rm=newsDaoimpl.selectNewsById(_id);
		return rm;
	
	}
*/
	@Override
	 //查全部新闻信息
	public List<NewsBean> getNews(String select_) {		
		List<NewsBean> newsList = newsDao.selectNews("2");
		HibernateSessionFactory.getSession().close();
		return newsList;
	}

	@Override
	 //添加新闻信息（传实体类对象）
	public boolean addnews(NewsBean r) {
		boolean flag = false;
		flag = newsDao.insertNews(r);
		session = HibernateSessionFactory.getSession();
		if(flag)
		{
			session.getTransaction().commit();
		}
		else session.getTransaction().rollback();
		session.close();
		return flag;
	}

	@Override
	 //删除新闻信息（根据id）
	public boolean removeNewsById(int _id) {	
		 session = HibernateSessionFactory.getSession();	
		//	 session.beginTransaction();
		NewsDaoImpl newsDaoImpl=new NewsDaoImpl();
		flag=newsDaoImpl.deleteNewsById(_id);
		if(flag){
		    session.getTransaction().commit();
		}
		else{
		    session.getTransaction().rollback();
		}
		session.close();
		return flag;
	}

	@Override
	//修改新闻信息（根据对象传参）
	public boolean changeNews(NewsBean r) {//直接扔对象，前提是放newsid,newstypeid还有其他信息
		 session = HibernateSessionFactory.getSession();			
			NewsDaoImpl newsDaoImpl=new NewsDaoImpl();
			flag=newsDaoImpl.updateNews(r);
			if(flag){
			    session.getTransaction().commit();
			}
			else{
			    session.getTransaction().rollback();
			}
			session.close();
		//	HibernateSessionFactory.getSession().close();
			return flag;
	}
	//分页案例
	public List<NewsBean> pagenationService() {
		List<NewsBean> newslist = newsDao.pagenationDao();	
		return newslist;
	}
}









