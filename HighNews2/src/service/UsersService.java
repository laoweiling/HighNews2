package service;

import java.util.List;

import entity.UsersBean;
/*模块：用户业务逻辑层处理
 * 组员：沈丽珍
 * 日期：2017年1月10日组合终结
 * 类名：UsersService接口
 * 任务：
 * （一）实现删除用户、修改用户业务逻辑处理接口 实现添加用户接口、查询用户接口
 * 方法
 * （1）用户增、删、改、查
 * */
public interface UsersService {
	 //按用户id号查找
	 public UsersBean getUserById(int _id);  
	//查全部用户信息
	 public List<UsersBean> getUser(String select_);  
	 //添加用户信息
	 public   boolean  addUser(UsersBean r);  
	  //删除用户信息
	 public   boolean  removeUserById(int _id);  
	  //更改用户信息
	 public   boolean  changeUser(UsersBean r);  
}
