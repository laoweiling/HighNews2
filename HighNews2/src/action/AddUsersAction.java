package action;


import Businesses.ManagerUsers;
import com.opensymphony.xwork2.ActionSupport;
import entity.UsersBean;
/*模块：增加用户模块（省去此类）
 * 组员：沈丽珍
 * 日期：2017年1月9日终结
 * 类名：AddUsersAction   继承ActionSupport类，实现java.io.Serializable
 * 属性：UsersBean usersBean
 * 用户类usersBean对象get和set方法
 * 方法
 * （1）execute()方法  
 * （2）UsersBean的get和set方法
 * */
public class AddUsersAction extends ActionSupport implements java.io.Serializable{
	private UsersBean usersBean;
	public UsersBean getUsersBean() {
		return usersBean;
	}	
	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}
	//插入用户方法
	public String execute(){
		System.out.println("user用户信息："+usersBean.getUsername()+" "+usersBean.getUserpwd());
		ManagerUsers managerUsers=new ManagerUsers();
		managerUsers.insertUsers(usersBean);
		return SUCCESS;
	}
}
