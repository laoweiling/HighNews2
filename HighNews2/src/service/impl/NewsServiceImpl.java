package service.impl;

import java.util.List;
import java.util.Vector;

import org.hibernate.Transaction;
import org.hibernate.Session;   //Ҫ�����������hibernate����Ҫ

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import service.NewsService;
import util.HibernateSessionFactory;
import entity.NewsBean;
/*ģ�飺����ҵ���߼��㴦��
 * ��Ա���ƻܡ���ΰ��
 * ���ڣ�2017��1��11������ս�
 * ������NewsService�ӿ�ʵ����
 * ����
 * ��һ���ƻܣ�ʵ��ɾ�����š��޸�����ҵ���߼�����ӿ�
 * ��������ΰ�᣺ ʵ��������Žӿڡ���ѯ���Žӿڡ���ҳ�ӿ�ҵ���߼�
 * ����
 * ��1��������Ϣɾ�����޸ķ���
 * ��2��������š���ѯ���ŷ���
 * */
public class NewsServiceImpl implements NewsService, java.io.Serializable{
	Session session;
	boolean flag=false;
	private NewsDao newsDao = new NewsDaoImpl();
	@Override
	 //��������id���ҵ�����Ϣ//�����ͺŲ��ң���id��
	public NewsBean getNewsById(int _id) {
		NewsBean news = newsDao.selectNewsById(_id);
		//�ر�session
		HibernateSessionFactory.getSession().close();
		return news;		
	}	
	/*  
	 //huanghuai��������
	@Override
	public NewsBean getNewsById(int _id) {
		NewsDao newsDaoimpl=new NewsDaoImpl();
		NewsBean rm=newsDaoimpl.selectNewsById(_id);
		return rm;
	
	}
*/
	@Override
	 //��ȫ��������Ϣ
	public List<NewsBean> getNews(String select_) {		
		List<NewsBean> newsList = newsDao.selectNews("2");
		HibernateSessionFactory.getSession().close();
		return newsList;
	}

	@Override
	 //���������Ϣ����ʵ�������
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
	 //ɾ��������Ϣ������id��
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
	//�޸�������Ϣ�����ݶ��󴫲Σ�
	public boolean changeNews(NewsBean r) {//ֱ���Ӷ���ǰ���Ƿ�newsid,newstypeid����������Ϣ
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
	//��ҳ����
	public List<NewsBean> pagenationService() {
		List<NewsBean> newslist = newsDao.pagenationDao();	
		return newslist;
	}
}









