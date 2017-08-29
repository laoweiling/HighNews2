package dao.impl;

import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.NewsDao;
import util.HibernateSessionFactory;
import entity.NewsBean;
import entity.NewstypeBean;
import entity.UsersBean;
/*模块：新闻接口
 * 组员：黄卉、劳伟玲
 * 日期：2017年1月11日组合终结
 * 类名：NewsDao接口
 * 任务：
 * （一）黄卉：实现删除新闻接口、修改新闻接口
 * （二）劳伟玲： 实现添加新闻接口、查询新闻接口、分页接口方法
 * 属性：无
 * 方法
 * （1）新闻信息删除、修改方法
 * （2）添加新闻、查询新闻方法
 * （3）分页实现方法
 * */
public class NewsDaoImpl implements NewsDao , java.io.Serializable{
     boolean flag=false;
     Session session;
	@Override
	//根据id传参，删除新闻信息
	public boolean deleteNewsById(int newsid) {
		session = (Session) HibernateSessionFactory.getSession();	
		 session.beginTransaction();		
		  System.out.println(newsid);
	      NewsBean newsBean=new NewsBean();
	      newsBean.setNewsid(newsid);
	      session.delete(newsBean);
	    flag=true;
		return flag;
		  /*
		   //方法二：
		  String hql="delete NewsBean where newsid=:newsid";
	      Transaction t=null;
	      try
	      {
	        t=session.beginTransaction();
	         Query q=session.createQuery(hql);
	          q.setParameter("newsid", newsid);
	          q.executeUpdate();
	          t.commit();
	      }
	      catch(Exception ex)
	      {    	  
	       if(t!=null)
	       {
	        t.rollback();
	       }
	      }*/
	    
	}
	@Override
	//根据新闻实体类对象传参，添加新闻信息
	public boolean insertNews(NewsBean nB) {
	     Session session = HibernateSessionFactory.getSession();  
	      session.beginTransaction();
	      NewstypeBean ntb = (NewstypeBean)session.get(NewstypeBean.class, nB.getNewsTypebean().getTypeid());
	        nB.setNewsTypebean(ntb);
	      session.save(nB);
	      //在service包中处理事务提交    
	     return true;        
	    }
	//问题：newstype为空 延迟加载问题，解决方法：迫切抓取
	@Override
	//根据新闻id查找单个新闻信息
	public NewsBean selectNewsById(int newsid) {
		//第一种做法：
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from NewsBean nb where nb.newsid = :newsid");
        query.setInteger("newsid", newsid);//from NewsBean nb left join fetch nb.newsTypebean where nb.newsid = :newsid
        return (NewsBean) query.uniqueResult();
        //第二种做法：
//        Session session = HibernateSessionFactory.getSession();    
//        NewsBean news=(NewsBean)session.get(entity.NewsBean.class, 1);
//        return news;
	}
	@Override
	//分页查找新闻信息
	public List<NewsBean> selectNews(String selectType) {	
	        Session session = HibernateSessionFactory.getSession();      
	        Query query = session.createQuery("from NewsBean nb");
	        return query.list();
	}
	@Override
	//根据传新闻实体类参数，修改新闻信息
	public boolean updateNews(NewsBean nB) {
		  session = HibernateSessionFactory.getSession();	
		  session.beginTransaction();
		  NewsBean t = (NewsBean) session.get(NewsBean.class, nB.getNewsid());	  
		  NewstypeBean 	NewstypeBean= nB.getNewsTypebean();	  
		  System.out.println("NewstypeBean:"+NewstypeBean);	  
		  t.setNewsTypebean(NewstypeBean);//重新set信息到对象中
			t.setAuthor(nB.getAuthor());		
			t.setNewspic(nB.getNewspic());
			t.setContent(nB.getContent());
			t.setNewstitle(nB.getNewstitle());
			t.setPubtime(nB.getPubtime());
    	flag=true;
		return flag;
	}
	//分页案例
    public List<NewsBean> pagenationDao() {
        Session session = HibernateSessionFactory.getSession();
        //仅仅找出了员工,不含部门信息的.
        Query query = session.createQuery("from NewsBean nb");   
        //设置第一行
        //query.setFirstResult(1);
        //设置每页最大行数.
        //query.setMaxResults(10);   
        return query.list();
    }  
}



/*/黄卉/
public boolean insertNews(NewsBean nB) {
	    Session session = HibernateSessionFactory.getSession();	
	    
	    session.beginTransaction();
		System.out.println(nB);

		session = HibernateSessionFactory.getSession();	
		
		NewstypeBean news=(NewstypeBean)session.get(entity.NewstypeBean.class, nB.getNewsTypebean().getTypeid());
		
		session.save(nB);
		System.out.println("插入语句");
		System.out.println(nB);
		
		session.getTransaction().commit();
    	session.close();
    	flag=true;
		return flag;
	
}
*/

/*
 * public boolean insertNews(NewsBean nB) {
     Session session = HibernateSessionFactory.getSession();  
      session.beginTransaction();
      NewstypeBean ntb = (NewstypeBean)session.get(NewstypeBean.class, nB.getNewsTypebean().getTypeid());
        nB.setNewsTypebean(ntb);
      session.save(nB);
      //在service包中处理事务提交
         
     return true;        
    }
    @Override
    public NewsBean selectNewsById(int newsid) {
        //第一种做法：
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from NewsBean nb where nb.newsid = :newsid");
        query.setInteger("newsid", newsid);//from NewsBean nb left join fetch nb.newsTypebean where nb.newsid = :newsid
        return (NewsBean) query.uniqueResult();
        //第二种做法：
//        Session session = HibernateSessionFactory.getSession();    
//        NewsBean news=(NewsBean)session.get(entity.NewsBean.class, 1);
//        return news;
        
    }
    @Override
    public  List<NewsBean> selectNews(String selectType) {
        Session session = HibernateSessionFactory.getSession();
        
        Query query = session.createQuery("from NewsBean nb");
        return query.list();
    }  
 * 
 * */
