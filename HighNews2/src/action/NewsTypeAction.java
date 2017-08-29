package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import service.NewsTypeService;
import service.impl.NewsTypeServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.NewstypeBean;
/*ģ�飺�������ģ��
 * ��Ա���˹�ơ�����Դ
 * ���ܣ������������ӡ�ɾ�����޸ġ���ѯ����
 * ���ڣ�2017��1��9���ս�  
 * ������NewsTypeAction   �̳�ActionSupport�࣬ʵ��java.io.Serializable�� RequestAware, SessionAware, ApplicationAware, ModelDriven
 * ���ԣ� NewstypeBean newsTypeBean����
 * �û���usersBean����get��set����
 * ����
 * ��1����ɾ�Ĳ鷽��  
 * ��2�����Ե�get��set����
 * */
public class NewsTypeAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ModelDriven, java.io.Serializable{
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
	@Override
	public Object getModel() {
		return newsTypeBean;
	}

	public void setApplication(Map<String, Object> application) {
		application = application;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setRequest(Map<String, Object> request) {	
		this.request = request;
	}
	
	private NewstypeBean newsTypeBean;
	private NewsTypeService newsTypeServiceImpl=new NewsTypeServiceImpl();	
	public NewstypeBean getNewsTypeBean() {
		return newsTypeBean;
	}
	public void setNewsTypeBean(NewstypeBean newsTypeBean) {
		this.newsTypeBean = newsTypeBean;
	}
	//������������
	public String InsertNewsType(){
		newsTypeServiceImpl.addNewsType(newsTypeBean);
		return "insert_newsType";
	}
	//�޸���������
	public String UpdateNewsType(){
		System.out.println("newsTypeBean�û���Ϣ��"+newsTypeBean.getTypeid()+" "+newsTypeBean.getTypename());
		newsTypeServiceImpl.changeNewsType(newsTypeBean);
		return "update_newsType";
	}
	//ɾ���������ͷ���
	public String DeleteNewsTypeById(){
		System.out.println("newsTypeBean�û���Ϣ��"+newsTypeBean.getTypeid()+" "+newsTypeBean.getTypename());
		newsTypeServiceImpl.removeNewsTypeById(newsTypeBean.getTypeid());
	//	 List<NewstypeBean> allNewsType = newsTypeServiceImpl.getNewsType();
	//	 this.request.put("NewsType", allNewsType);
		return "delete_newsTypeById";
	}
	//��ѯ��������������Ϣ
	public String SelectNewsTypeById(){
		newsTypeServiceImpl.getNewsTypeById(newsTypeBean.getTypeid());
		return "select_newsTypeById";
	}
	//��ѯ��������������Ϣ
	public String SelectNewsType(){
		 List<NewstypeBean> allNewsType = newsTypeServiceImpl.getNewsType();
		 this.request.put("NewsType", allNewsType);
		 return "select_newsType";
	}
}
