package dao;

import java.util.List;
import java.util.Vector;

import entity.NewstypeBean;
/*ģ�飺�������ͽӿ�ʵ�ַ���
 * ��Ա������Դ���˹��
 * ���ڣ�2017��1��09��
 * ������NewsTypeDao�ӿ�
 * ����
 * ��һ������Դ��ʵ�ֲ��ҡ���ӹ���
 * �������˹�ƣ� ʵ��ɾ�����޸Ĺ���
 * ���ԣ���
 * ����
 * ��1������������Ϣɾ�����޸ķ���
 * ��2������������͡���ѯ���ŷ���
 * */
public interface NewsTypeDao {
	//���ݰ�����id�ŵ�������
	 public NewstypeBean selectNewstypeById(int _typeid);    
	//��ȫ����Ϣ
	 public List<NewstypeBean> selectNewstype();  
	 //���ݴ����������������
     public   boolean  insertnewstype(NewstypeBean r); 
     //����idɾ����������
	 public   boolean  deletenewstypeById(int _typeid); 
	 //���ݴ������޸���������
	 public   boolean  updatenewstype(NewstypeBean r);   
}
