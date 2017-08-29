package dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateSessionFactory;
import dao.NewsTypeDao;
import entity.NewstypeBean;
/*ģ�飺�������ͽӿ�ʵ�ַ���
 * ��Ա������Դ���˹��
 * ���ڣ�2017��1��09��
 * ������NewsTypeDao�ӿ�
 * ����
 * ��һ������Դ��ʵ�ֲ��ҡ���ӹ���
 * �������˹�ƣ� ʵ��ɾ�����޸Ĺ���
 * ���ԣ���
 * ����
 * ��1������������Ϣɾ�����޸ķ���
 * ��2������������͡���ѯ���ŷ���
 * */
public class NewsTypeDaoImpl implements NewsTypeDao, java.io.Serializable{
	@Override
	//����idɾ���û���Ϣ
	public boolean deletenewstypeById(int typeid) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		NewstypeBean ntb = (NewstypeBean) session.get(NewstypeBean.class, typeid);//�����ȴ����ݿ��ȡ���Ӧ��newtypd����Ȼ����ɾ����
		//���򣬻��ȡ�������󣬳��ֿգ�
		Query query = session.createQuery("from NewstypeBean where typeid = :typeid");
		query.setInteger("typeid", typeid);
		ntb.setTypeid(typeid);	
		session.delete(ntb);
		System.out.println(ntb);
		return true;
	}
	@Override
	//���ݶ����������������Ϣ
	public boolean insertnewstype(NewstypeBean r) {
		Session session = HibernateSessionFactory.getSession();
		session.save(r);
		return true;
	}
	@Override
	//����LIST���ͷ���ҵ���߼����ѯ������������Ϣ
	public List<NewstypeBean> selectNewstype() {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select newstype from NewstypeBean newstype");
		return query.list();
	}
	@Override
	//���ݴ��������Ͷ����޸�
	public boolean updatenewstype(NewstypeBean r) {
		Session session = HibernateSessionFactory.getSession();
		NewstypeBean ntsb = (NewstypeBean) session.get(NewstypeBean.class, r.getTypeid());
		session.beginTransaction();
		ntsb.setTypename(r.getTypename());
		session.save(ntsb);
		return true;
	}
	//��ѯ��������������Ϣ
	public NewstypeBean selectNewstypeById(int _typeid) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("select newstype from NewstypeBean newstype where typeid = :typeid");
		query.setInteger("typeid", _typeid);
		return (NewstypeBean) query.uniqueResult();
	}
}
