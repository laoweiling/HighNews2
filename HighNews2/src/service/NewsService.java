package service;

import java.util.List;

import entity.NewsBean;
/*ģ�飺����ҵ���߼��㴦��
 * ��Ա���ƻܡ���ΰ��
 * ���ڣ�2017��1��11������ս�
 * ������NewsService�ӿ�
 * ����
 * ��һ���ƻܣ�ʵ��ɾ�����š��޸�����ҵ���߼�����ӿ�
 * ��������ΰ�᣺ ʵ��������Žӿڡ���ѯ���Žӿڡ���ҳ�ӿ�ҵ���߼�
 * ����
 * ��1��������Ϣɾ�����޸ķ���
 * ��2��������š���ѯ���ŷ���
 * */
public interface NewsService {
	  //��������id���ҵ�����Ϣ//�����ͺŲ��ң���id��
	 public NewsBean getNewsById(int _id);  
	 //��ȫ��������Ϣ
	 public List<NewsBean> getNews(String select_); 
	 //���������Ϣ����ʵ�������
	 public   boolean  addnews(NewsBean r); 
	 //ɾ��������Ϣ������id��
	 public   boolean  removeNewsById(int _id);  
	 //�޸�������Ϣ�����ݶ��󴫲Σ�
	 public   boolean  changeNews(NewsBean r);   
}
