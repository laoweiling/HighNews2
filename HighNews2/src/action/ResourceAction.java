package action;

import com.opensymphony.xwork2.ActionSupport;
/*ģ�飺��תҳ��ģ��
 * ��Ա���ƻ�
 * ���ܣ���ת�������ҳ�桢��תɾ�����޸ġ���ѯ����ҳ��
 * ���ڣ�2017��1��10���ս�  
 * ������ResourceAction   �̳�ActionSupport�࣬ʵ��java.io.Serializable
 * ���ԣ�method��jspͨ��URL�����Ĳ�����
 * ����
 * ��1��method��get��set���� 
 * ��2��execute������ͨ��action�жϲ���
 * */
public class ResourceAction extends ActionSupport implements java.io.Serializable{
	private String method;//jsp����
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	//������add����ת�������ҳ�棬������ת��ѯ�������ŵ���ҳ
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
