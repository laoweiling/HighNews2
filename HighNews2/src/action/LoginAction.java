package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import service.impl.NewsServiceImpl;

import Businesses.LoginBusiness;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.NewsBean;
import entity.UsersBean;
/*模块：登陆用户模块
 * 组员：黄卉
 * 日期：2017年1月10日终结
 * 类名：LoginAction   继承BaseAction类，实现java.io.Serializable
 * 属性：admin  password  List类型的loginnewsList  typeid
 * 方法
 * （1）execute()方法  
 * （2）所有属性的get和set方法
 * */
public class LoginAction extends BaseAction implements java.io.Serializable{
	private String admin;
	private String password;
	 private List<NewsBean> loginnewsList;
	 private Integer typeid;
	 
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public List<NewsBean> getLoginnewsList() {
		return loginnewsList;
	}
	public void setLoginnewsList(List<NewsBean> loginnewsList) {
		this.loginnewsList = loginnewsList;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getPassword() {  //一定要get 和set方法，否则不能传到jsp
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//进行登陆操作。jsp传参，查询出数据传到jsp主页。显示所有数据。
	public String execute(){
		  LoginBusiness ld = new LoginBusiness();
	      UsersBean ub = new UsersBean();
	      ub = ld.login(admin, password);
	      if(ub.getUserleval() != 0){
	    	  NewsServiceImpl newsService=new NewsServiceImpl();
	    	this.loginnewsList = newsService.getNews("2");	    	
	  		System.out.println(loginnewsList.size());	  
	  		request.put("loginnewsList", loginnewsList);  		
	  		ActionContext actionContext = ActionContext.getContext(); 			
			session=(Map) actionContext.get("session"); 
			session.put("loginnewsList", loginnewsList);//把List put进去页面。并且可以在这里打印出来。而页面上可以拿到
			//报错原因：不能拿到list的关联对象的属性值。解决方法：必须用get和set方法，继承了baseaction后解决
	    	  return "success";
	      }	  
	       else {
	    	   return "fail";
	       }
	}
	

}
