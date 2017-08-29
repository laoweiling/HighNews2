package dao;

import java.util.List;
import java.util.Vector;

import entity.NewsBean;
import entity.UsersBean;
/*模块：用户接口
 * 组员：沈丽珍
 * 日期：2017年1月09日完成
 * 类名：UsersDao接口
 * 任务：实现增加用户、删除用户、查询用户、修改用户方法
 * 属性：无
 * 方法：增加用户、删除用户、查询用户、修改用户方法
 * */
public interface UsersDao {
	//传id：单个查找用户
	public UsersBean selectUsersById(int _userid); 
	//传无意义：查询所有用户
	public List<UsersBean> selectUsers(String select_type);
	//传用户对象：插入用户
	public  boolean  insertUsers(UsersBean r);
	//传id：删除用户
	public boolean  deleteUsersById(int _userid);   
	//穿对象：修改用户信息
	public  boolean  updateUsers(UsersBean r);    //改
}
