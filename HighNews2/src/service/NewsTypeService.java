package service;

import java.util.List;

import entity.NewstypeBean;
/*ģ�飺��������ҵ���߼��㴦��
 * ��Ա��ѡ��Դ���˹��
 * ���ڣ�2017��1��10������ս�
 * ������NewsTypeService�ӿ�
 * ����
 * ��һ���˹�ƣ�ʵ��ɾ�����š��޸�����ҵ���߼�����ӿ�
 * ������ѡ��Դ�� ʵ��������Žӿڡ���ѯ���Žӿ�
 * ����
 * ��1������������Ϣɾ�����޸����ͷ���
 * ��2������������͡���ѯ�������ͷ���
 * */
public interface NewsTypeService {
	  //�����ͺŲ������ͺŲ���
	 public NewstypeBean getNewsTypeById(int _typeid); 
	//��ѯ������������
	 public List<NewstypeBean> getNewsType();  
	 //������������
	 public   boolean  addNewsType(NewstypeBean r);   
	  //ɾ����������
	 public   boolean  removeNewsTypeById(int _typeid); 
	 //�޸���������
	 public   boolean  changeNewsType(NewstypeBean r);   

}
