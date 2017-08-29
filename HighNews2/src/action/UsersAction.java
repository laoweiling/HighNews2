package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import entity.UsersBean;
import service.UsersService;
import service.impl.UsersServiceImpl;
/*模块：用户操作action模块
 * 组员：沈丽珍
 * 功能：增加用户，删除、修改查询用户操作。调用业务逻辑层
 * 日期：//lizhen修改  20170111
 * 类名：UsersAction   继承ActionSupport类，实现java.io.Serializable
 * 属性：usersBean  id,method，dothing
 * 方法
 * （1）属性的get和set方法 
 * （2）查询、增加、修改、删除操作
 * */
public class UsersAction extends BaseAction implements java.io.Serializable{
	private UsersService userService=new UsersServiceImpl();
	private UsersBean usersBean;
	private int id;
	private String method;
	private String dothing;
	public String getDothing() {
		return dothing;
	}
	public void setDothing(String dothing) {
		this.dothing = dothing;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public UsersBean getUsersBean() {
		return usersBean;
	}
	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//插入用户
	public String InsertUser(){
		userService.addUser(usersBean);
		return "insert_user";
	}
	//删除用户
	public String DeleteUserById(){
		userService.removeUserById(id);
		return "delete_userById";
	}
	//修改用户信息
	public String UpdateUser(){
		userService.changeUser(usersBean);
		return "update_user";	
	}
	//查找单个用户
	public String SelectUserById(){
		ActionContext actionContext = ActionContext.getContext(); 
		session=(Map) actionContext.get("session"); 
		//session.put("alluser", listUser);
		UsersBean user=userService.getUserById(id);
		session.put("oneuser", user);
		return dothing;
	}
	//查询所有用户信息
	public String resourceUserAction(){
		
		if("sel".equals(method)){
			ActionContext actionContext = ActionContext.getContext(); 
			List<UsersBean> listUser=userService.getUser("2");
			session=(Map) actionContext.get("session"); 
			session.put("alluser", listUser);
		}
		return method;
	}
}
