package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import entity.UsersBean;
import service.UsersService;
import service.impl.UsersServiceImpl;
/*ģ�飺�û�����actionģ��
 * ��Ա��������
 * ���ܣ������û���ɾ�����޸Ĳ�ѯ�û�����������ҵ���߼���
 * ���ڣ�//lizhen�޸�  20170111
 * ������UsersAction   �̳�ActionSupport�࣬ʵ��java.io.Serializable
 * ���ԣ�usersBean  id,method��dothing
 * ����
 * ��1�����Ե�get��set���� 
 * ��2����ѯ�����ӡ��޸ġ�ɾ������
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
	//�����û�
	public String InsertUser(){
		userService.addUser(usersBean);
		return "insert_user";
	}
	//ɾ���û�
	public String DeleteUserById(){
		userService.removeUserById(id);
		return "delete_userById";
	}
	//�޸��û���Ϣ
	public String UpdateUser(){
		userService.changeUser(usersBean);
		return "update_user";	
	}
	//���ҵ����û�
	public String SelectUserById(){
		ActionContext actionContext = ActionContext.getContext(); 
		session=(Map) actionContext.get("session"); 
		//session.put("alluser", listUser);
		UsersBean user=userService.getUserById(id);
		session.put("oneuser", user);
		return dothing;
	}
	//��ѯ�����û���Ϣ
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
