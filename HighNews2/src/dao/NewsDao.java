package dao;


import java.util.List;
import entity.NewsBean;
/*ģ�飺���Žӿ�
 * ��Ա���ƻܡ���ΰ��
 * ���ڣ�2017��1��11������ս�
 * ������NewsDao�ӿ�
 * ����
 * ��һ���ƻܣ�ʵ��ɾ�����Žӿڡ��޸����Žӿ�
 * ��������ΰ�᣺ ʵ��������Žӿڡ���ѯ���Žӿڡ���ҳ�ӿڷ���
 * ���ԣ���
 * ����
 * ��1��������Ϣɾ�����޸ķ���
 * ��2��������š���ѯ���ŷ���
 * ��3����ҳʵ�ַ���
 * */
public interface NewsDao {
	//�����û����������������
	public boolean insertNews(NewsBean nB);
	//��ѯ����������Ϣ��id����
	public NewsBean selectNewsById(int _newsid);  
	//��ѯȫ��������Ϣ�����α�ʶ
	public List<NewsBean> selectNews(String select_type);   
	//ɾ����������
	public boolean  deleteNewsById(int _newsid); 
	//�޸�������Ϣ�ӿڷ���
	public  boolean  updateNews(NewsBean nB);   
	//����ҳ������
	public List<NewsBean> pagenationDao();

}



