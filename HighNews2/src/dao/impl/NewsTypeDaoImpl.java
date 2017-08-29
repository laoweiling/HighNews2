package dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateSessionFactory;
import dao.NewsTypeDao;
import entity.NewstypeBean;
/*模块：新闻类型接口实现方法
 * 组员：冼海源、岑斯云
 * 日期：2017年1月09日
 * 类名：NewsTypeDao接口
 * 任务：
 * （一）冼海源：实现查找、添加功能
 * （二）岑斯云： 实现删除、修改功能
 * 属性：无
 * 方法
 * （1）新闻类型信息删除、修改方法
 * （2）添加新闻类型、查询新闻方法
 * */
public class NewsTypeDaoImpl implements NewsTypeDao, java.io.Serializable{
	@Override
	//根据id删除用户信息
	public boolean deletenewstypeById(int typeid) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		NewstypeBean ntb = (NewstypeBean) session.get(NewstypeBean.class, typeid);//这里先从数据库获取相对应的newtypd对象，然后再删除。
		//否则，会获取不到对象，出现空，
		Query query = session.createQuery("from NewstypeBean where typeid = :typeid");
		query.setInteger("typeid", typeid);
		ntb.setTypeid(typeid);	
		session.delete(ntb);
		System.out.println(ntb);
		return true;
	}
	@Override
	//根据对象插入新闻类型信息
	public boolean insertnewstype(NewstypeBean r) {
		Session session = HibernateSessionFactory.getSession();
		session.save(r);
		return true;
	}
	@Override
	//根据LIST类型返回业务逻辑层查询的新闻类型信息
	public List<NewstypeBean> selectNewstype() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select newstype from NewstypeBean newstype");
		return query.list();
	}
	@Override
	//根据传新闻类型对象修改
	public boolean updatenewstype(NewstypeBean r) {
		Session session = HibernateSessionFactory.getSession();
		NewstypeBean ntsb = (NewstypeBean) session.get(NewstypeBean.class, r.getTypeid());
		session.beginTransaction();
		ntsb.setTypename(r.getTypename());
		session.save(ntsb);
		return true;
	}
	//查询单条新闻类型信息
	public NewstypeBean selectNewstypeById(int _typeid) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select newstype from NewstypeBean newstype where typeid = :typeid");
		query.setInteger("typeid", _typeid);
		return (NewstypeBean) query.uniqueResult();
	}
}
