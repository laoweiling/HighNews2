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
/*ģ�飺���Žӿ�
 * ��Ա���ƻܡ���ΰ��
 * ���ڣ�2017��1��11������ս�
 * ������NewsDao�ӿ�
 * ����
 * ��һ���ƻܣ�ʵ��ɾ�����Žӿڡ��޸����Žӿ�
 * ��������ΰ�᣺ ʵ��������Žӿڡ���ѯ���Žӿڡ���ҳ�ӿڷ���
 * ���ԣ���
 * ����
 * ��1��������Ϣɾ�����޸ķ���
 * ��2��������š���ѯ���ŷ���
 * ��3����ҳʵ�ַ���
 * */
public class NewsDaoImpl implements NewsDao , java.io.Serializable{
     boolean flag=false;
     Session session;
	@Override
	//����id���Σ�ɾ��������Ϣ
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
		   //��������
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
	//��������ʵ������󴫲Σ����������Ϣ
	public boolean insertNews(NewsBean nB) {
	     Session session = HibernateSessionFactory.getSession();  
	      session.beginTransaction();
	      NewstypeBean ntb = (NewstypeBean)session.get(NewstypeBean.class, nB.getNewsTypebean().getTypeid());
	        nB.setNewsTypebean(ntb);
	      session.save(nB);
	      //��service���д��������ύ    
	     return true;        
	    }
	//���⣺newstypeΪ�� �ӳټ������⣬�������������ץȡ
	@Override
	//��������id���ҵ���������Ϣ
	public NewsBean selectNewsById(int newsid) {
		//��һ��������
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from NewsBean nb where nb.newsid = :newsid");
        query.setInteger("newsid", newsid);//from NewsBean nb left join fetch nb.newsTypebean where nb.newsid = :newsid
        return (NewsBean) query.uniqueResult();
        //�ڶ���������
//        Session session = HibernateSessionFactory.getSession();    
//        NewsBean news=(NewsBean)session.get(entity.NewsBean.class, 1);
//        return news;
	}
	@Override
	//��ҳ����������Ϣ
	public List<NewsBean> selectNews(String selectType) {	
	        Session session = HibernateSessionFactory.getSession();      
	        Query query = session.createQuery("from NewsBean nb");
	        return query.list();
	}
	@Override
	//���ݴ�����ʵ����������޸�������Ϣ
	public boolean updateNews(NewsBean nB) {
		  session = HibernateSessionFactory.getSession();	
		  session.beginTransaction();
		  NewsBean t = (NewsBean) session.get(NewsBean.class, nB.getNewsid());	  
		  NewstypeBean 	NewstypeBean= nB.getNewsTypebean();	  
		  System.out.println("NewstypeBean:"+NewstypeBean);	  
		  t.setNewsTypebean(NewstypeBean);//����set��Ϣ��������
			t.setAuthor(nB.getAuthor());		
			t.setNewspic(nB.getNewspic());
			t.setContent(nB.getContent());
			t.setNewstitle(nB.getNewstitle());
			t.setPubtime(nB.getPubtime());
    	flag=true;
		return flag;
	}
	//��ҳ����
    public List<NewsBean> pagenationDao() {
        Session session = HibernateSessionFactory.getSession();
        //�����ҳ���Ա��,����������Ϣ��.
        Query query = session.createQuery("from NewsBean nb");   
        //���õ�һ��
        //query.setFirstResult(1);
        //����ÿҳ�������.
        //query.setMaxResults(10);   
        return query.list();
    }  
}



/*/�ƻ�/
public boolean insertNews(NewsBean nB) {
	    Session session = HibernateSessionFactory.getSession();	
	    
	    session.beginTransaction();
		System.out.println(nB);

		session = HibernateSessionFactory.getSession();	
		
		NewstypeBean news=(NewstypeBean)session.get(entity.NewstypeBean.class, nB.getNewsTypebean().getTypeid());
		
		session.save(nB);
		System.out.println("�������");
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
      //��service���д��������ύ
         
     return true;        
    }
    @Override
    public NewsBean selectNewsById(int newsid) {
        //��һ��������
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from NewsBean nb where nb.newsid = :newsid");
        query.setInteger("newsid", newsid);//from NewsBean nb left join fetch nb.newsTypebean where nb.newsid = :newsid
        return (NewsBean) query.uniqueResult();
        //�ڶ���������
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
