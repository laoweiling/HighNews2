package action;

import com.opensymphony.xwork2.ActionSupport;
/*ģ�飺���������תҳ��ģ�飨����
 * ��Ա����ΰ��
 * ���ܣ���ת��ӡ�ɾ�����޸ġ���ѯ��������ҳ��
 * ���ڣ�2017��1��11�������ս�  
 * ������ResourceNewsTypeAction   �̳�ActionSupport�࣬ʵ��java.io.Serializable
 * ���ԣ�method��jspͨ��URL�����Ĳ�����
 * ����
 * ��1��method��get��set���� ���������ŵ�resource������
 * ��2��execute������ͨ��action�жϲ���
 * */
public class ResourceNewsTypeAction extends ActionSupport implements java.io.Serializable{
	private String method;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	//��תҳ��
	public String execute(){
		System.out.println(method);
		if(method.equals("add")){
			return "addtab";
		}
		else{	
			return "admintab";
		}
	}
}
