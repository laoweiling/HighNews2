package service.impl;

import java.util.List;

import org.hibernate.Session;

import util.HibernateSessionFactory;
import dao.NewsDao;
import dao.UsersDao;
import dao.impl.NewsDaoImpl;
import dao.impl.UsersDaoImpl;
import entity.NewsBean;
import entity.UsersBean;
/*ģ�飺�û�ҵ���߼��㴦��
 * ��Ա��������
 * ���ڣ�2017��1��10������ս�
 * ������UsersService�ӿ�ʵ����
 * ����
 * ��һ��ʵ��ɾ���û����޸��û�ҵ���߼�����ӿ� ʵ������û��ӿڡ���ѯ�û��ӿ�
 * ����
 * ��1���û�����ɾ���ġ���
 * */
//�û�ҵ���߼���ʵ����  --lizhen 20170110
public class UsersServiceImpl implements service.UsersService , java.io.Serializable{
	private UsersDao userdao=new UsersDaoImpl();
	boolean flag=false;
	//���û�id�Ų���
	@Override
	public UsersBean getUserById(int _id) {
		UsersBean user=userdao.selectUsersById(_id);
		HibernateSessionFactory.getSession().close();//�رջỰ
		return user;
	}
	//���������û�
	@Override
	public List<UsersBean> getUser(String select_) {
		List<UsersBean> userList=userdao.selectUsers(select_);
		HibernateSessionFactory.getSession().close();
		return userList;
	}
	//����û�
	@Override
	public boolean addUser(UsersBean r) {
		Session session = HibernateSessionFactory.getSession();
		UsersBean user=userdao.selectUsersById(r.getUserid());
		if(user==null)
		{
			session.beginTransaction();
			userdao.insertUsers(r);
			session.getTransaction().commit();
			session.close();
			flag=true;
		}
		return flag;
	}
	//ɾ���û�
	@Override
	public boolean removeUserById(int _id) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		flag = userdao.deleteUsersById(_id);
		session.getTransaction().commit();
		session.close();
		return flag;
	}
	//�����û�
	@Override
	public boolean changeUser(UsersBean r) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		flag=userdao.updateUsers(r);
		session.getTransaction().commit();
		session.close();
		return flag;
	}	
}
