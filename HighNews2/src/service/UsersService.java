package service;

import java.util.List;

import entity.UsersBean;
/*ģ�飺�û�ҵ���߼��㴦��
 * ��Ա��������
 * ���ڣ�2017��1��10������ս�
 * ������UsersService�ӿ�
 * ����
 * ��һ��ʵ��ɾ���û����޸��û�ҵ���߼�����ӿ� ʵ������û��ӿڡ���ѯ�û��ӿ�
 * ����
 * ��1���û�����ɾ���ġ���
 * */
public interface UsersService {
	 //���û�id�Ų���
	 public UsersBean getUserById(int _id);  
	//��ȫ���û���Ϣ
	 public List<UsersBean> getUser(String select_);  
	 //����û���Ϣ
	 public   boolean  addUser(UsersBean r);  
	  //ɾ���û���Ϣ
	 public   boolean  removeUserById(int _id);  
	  //�����û���Ϣ
	 public   boolean  changeUser(UsersBean r);  
}
