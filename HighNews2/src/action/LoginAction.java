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
/*ģ�飺��½�û�ģ��
 * ��Ա���ƻ�
 * ���ڣ�2017��1��10���ս�
 * ������LoginAction   �̳�BaseAction�࣬ʵ��java.io.Serializable
 * ���ԣ�admin  password  List���͵�loginnewsList  typeid
 * ����
 * ��1��execute()����  
 * ��2���������Ե�get��set����
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
	public String getPassword() {  //һ��Ҫget ��set�����������ܴ���jsp
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//���е�½������jsp���Σ���ѯ�����ݴ���jsp��ҳ����ʾ�������ݡ�
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
			session.put("loginnewsList", loginnewsList);//��List put��ȥҳ�档���ҿ����������ӡ��������ҳ���Ͽ����õ�
			//����ԭ�򣺲����õ�list�Ĺ������������ֵ�����������������get��set�������̳���baseaction����
	    	  return "success";
	      }	  
	       else {
	    	   return "fail";
	       }
	}
	

}
