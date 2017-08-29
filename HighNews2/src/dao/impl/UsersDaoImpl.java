package dao.impl;

import java.util.List;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import dao.UsersDao;
import util.HibernateSessionFactory;
import entity.UsersBean;
/*ģ�飺�û��ӿ�
 * ��Ա��������
 * ���ڣ�2017��1��09�����
 * ������UsersDao�ӿ�
 * ����ʵ�������û���ɾ���û�����ѯ�û����޸��û�����
 * ���ԣ�flag
 * �����������û���ɾ���û�����ѯ�û����޸��û�����
 * */
public class UsersDaoImpl implements UsersDao, java.io.Serializable{
	boolean flag=false;
	//����û�  --�����޸�20170109
		@Override
		public boolean insertUsers(UsersBean r) {
			System.out.println("Dao.UsersDaoImpl.insertUsers");
			Session session = HibernateSessionFactory.getSession();
			session.save(r);
			flag=true;
			return flag;
		}
	//ͨ��id�����û�  --���� 20170109
	@Override
	public UsersBean selectUsersById(int userid) {
		System.out.println("Dao.UsersDaoImpl.selectUsers(ById)");
		Session session = HibernateSessionFactory.getSession();
		UsersBean user=(UsersBean)session.get(entity.UsersBean.class, userid);
		return user;
	}
	//���������û�  --���� 20170109
	@Override
	public List<UsersBean> selectUsers(String selectType) {
		System.out.println("Dao.UsersDaoImpl.selectUsers(ByType)");
		Session session = HibernateSessionFactory.getSession();
		List<UsersBean> userList=null;
		if(selectType.equals("2")){
			Query query = session.createQuery("from UsersBean");
			userList = query.list();
		}
		return userList;
	}
	//�����û�  --���� 20170110
	@Override
	public boolean updateUsers(UsersBean r) {
		System.out.println("Dao.UsersDaoImpl.updateUsers");
		Session session = HibernateSessionFactory.getSession();
		session.update(r);
		flag=true;
		return flag;
	}
	//ɾ���û�  --�����޸�20170109
	@Override
	public boolean deleteUsersById(int userid) {
		System.out.println("Dao.UsersDaoImpl.deleteUsers");
		Session session = HibernateSessionFactory.getSession();
		UsersBean user=new UsersBean();
		user.setUserid(userid);
		session.delete(user);
		flag=true;
		return flag;
	}
}

/*
 * 	public static void main(String[] args){
		UsersBean usersBean=new UsersBean();
		usersBean.setUsername("f");
		usersBean.setUserpwd("123456");
		usersBean.setUserleval(1);
		UsersDaoImpl usersDao=new UsersDaoImpl();
		boolean flag=usersDao.insertUsers(usersBean);
		System.out.println(flag);
	}
 * */
