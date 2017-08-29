package dao;

import java.util.List;
import java.util.Vector;

import entity.NewsBean;
import entity.UsersBean;
/*ģ�飺�û��ӿ�
 * ��Ա��������
 * ���ڣ�2017��1��09�����
 * ������UsersDao�ӿ�
 * ����ʵ�������û���ɾ���û�����ѯ�û����޸��û�����
 * ���ԣ���
 * �����������û���ɾ���û�����ѯ�û����޸��û�����
 * */
public interface UsersDao {
	//��id�����������û�
	public UsersBean selectUsersById(int _userid); 
	//�������壺��ѯ�����û�
	public List<UsersBean> selectUsers(String select_type);
	//���û����󣺲����û�
	public  boolean  insertUsers(UsersBean r);
	//��id��ɾ���û�
	public boolean  deleteUsersById(int _userid);   
	//�������޸��û���Ϣ
	public  boolean  updateUsers(UsersBean r);    //��
}
