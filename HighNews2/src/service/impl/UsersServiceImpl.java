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
/*模块：用户业务逻辑层处理
 * 组员：沈丽珍
 * 日期：2017年1月10日组合终结
 * 类名：UsersService接口实现类
 * 任务：
 * （一）实现删除用户、修改用户业务逻辑处理接口 实现添加用户接口、查询用户接口
 * 方法
 * （1）用户增、删、改、查
 * */
//用户业务逻辑层实现类  --lizhen 20170110
public class UsersServiceImpl implements service.UsersService , java.io.Serializable{
	private UsersDao userdao=new UsersDaoImpl();
	boolean flag=false;
	//按用户id号查找
	@Override
	public UsersBean getUserById(int _id) {
		UsersBean user=userdao.selectUsersById(_id);
		HibernateSessionFactory.getSession().close();//关闭会话
		return user;
	}
	//查找所有用户
	@Override
	public List<UsersBean> getUser(String select_) {
		List<UsersBean> userList=userdao.selectUsers(select_);
		HibernateSessionFactory.getSession().close();
		return userList;
	}
	//添加用户
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
	//删除用户
	@Override
	public boolean removeUserById(int _id) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		flag = userdao.deleteUsersById(_id);
		session.getTransaction().commit();
		session.close();
		return flag;
	}
	//更新用户
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
