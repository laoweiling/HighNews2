package action;


import Businesses.ManagerUsers;
import com.opensymphony.xwork2.ActionSupport;
import entity.UsersBean;
/*ģ�飺�����û�ģ�飨ʡȥ���ࣩ
 * ��Ա��������
 * ���ڣ�2017��1��9���ս�
 * ������AddUsersAction   �̳�ActionSupport�࣬ʵ��java.io.Serializable
 * ���ԣ�UsersBean usersBean
 * �û���usersBean����get��set����
 * ����
 * ��1��execute()����  
 * ��2��UsersBean��get��set����
 * */
public class AddUsersAction extends ActionSupport implements java.io.Serializable{
	private UsersBean usersBean;
	public UsersBean getUsersBean() {
		return usersBean;
	}	
	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}
	//�����û�����
	public String execute(){
		System.out.println("user�û���Ϣ��"+usersBean.getUsername()+" "+usersBean.getUserpwd());
		ManagerUsers managerUsers=new ManagerUsers();
		managerUsers.insertUsers(usersBean);
		return SUCCESS;
	}
}
