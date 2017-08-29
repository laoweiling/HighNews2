package service.impl;

import java.util.List;

import org.hibernate.Session;

import dao.impl.NewsTypeDaoImpl;

import service.NewsTypeService;
import util.HibernateSessionFactory;
import entity.NewstypeBean;
/*模块：新闻类型业务逻辑层处理
 * 组员：选海源、岑斯云
 * 日期：2017年1月10日组合终结
 * 类名：NewsTypeService接口实现
 * 任务：
 * （一）岑斯云：实现删除新闻、修改新闻业务逻辑处理接口
 * （二）选海源： 实现添加新闻接口、查询新闻接口
 * 方法
 * （1）新闻类型信息删除、修改类型方法
 * （2）添加新闻类型、查询新闻类型方法
 * */
public class NewsTypeServiceImpl implements NewsTypeService , java.io.Serializable{
	private static NewsTypeDaoImpl dao = new NewsTypeDaoImpl();
	@Override
	  //按类型号查找类型号查找
	public NewstypeBean getNewsTypeById(int _typeid) {
		Session session = HibernateSessionFactory.getSession();
		return dao.selectNewstypeById(_typeid);
	}
	@Override
	//查询所有新闻类型
	public List<NewstypeBean> getNewsType() {
		// TODO Auto-generated method stub
	//	Session session = HibernateSessionFactory.getSession();
		return dao.selectNewstype();
	}
	 //增加新闻类型
	@Override
	public boolean addNewsType(NewstypeBean r) {
		Session session = HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			
			dao.insertnewstype(r);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		return false;
	}

	@Override
	 //删除新闻类型
	public boolean removeNewsTypeById(int _typeid) {
		Session session = HibernateSessionFactory.getSession();
		try {
			
			dao.deletenewstypeById(_typeid);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return false;
	}

	//修改新闻类型
	@Override
	public boolean changeNewsType(NewstypeBean r) {
		Session session = HibernateSessionFactory.getSession();
		try {
			dao.updatenewstype(r);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return false;
	}
	
}
