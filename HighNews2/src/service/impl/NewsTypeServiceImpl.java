package service.impl;

import java.util.List;

import org.hibernate.Session;

import dao.impl.NewsTypeDaoImpl;

import service.NewsTypeService;
import util.HibernateSessionFactory;
import entity.NewstypeBean;
/*ģ�飺��������ҵ���߼��㴦��
 * ��Ա��ѡ��Դ���˹��
 * ���ڣ�2017��1��10������ս�
 * ������NewsTypeService�ӿ�ʵ��
 * ����
 * ��һ���˹�ƣ�ʵ��ɾ�����š��޸�����ҵ���߼�����ӿ�
 * ������ѡ��Դ�� ʵ��������Žӿڡ���ѯ���Žӿ�
 * ����
 * ��1������������Ϣɾ�����޸����ͷ���
 * ��2������������͡���ѯ�������ͷ���
 * */
public class NewsTypeServiceImpl implements NewsTypeService , java.io.Serializable{
	private static NewsTypeDaoImpl dao = new NewsTypeDaoImpl();
	@Override
	  //�����ͺŲ������ͺŲ���
	public NewstypeBean getNewsTypeById(int _typeid) {
		Session session = HibernateSessionFactory.getSession();
		return dao.selectNewstypeById(_typeid);
	}
	@Override
	//��ѯ������������
	public List<NewstypeBean> getNewsType() {
		// TODO Auto-generated method stub
	//	Session session = HibernateSessionFactory.getSession();
		return dao.selectNewstype();
	}
	 //������������
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
	 //ɾ����������
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

	//�޸���������
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
