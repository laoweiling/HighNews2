package action;

import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import service.NewsService;
import service.impl.NewsServiceImpl;
import entity.NewsBean;
import entity.NewstypeBean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/*ģ�飺����ģ��
 * ���ܣ��������š�ɾ�����š��޸����š�������ѯ�����Լ������ѯ����
 * ��Ա���ƻ�  ��ΰ��
 * �������䣺��һ����ѯ���š�������ţ���ΰ�ᣩ  ������ɾ���������޸����ţ��ƻܣ�
 * ���ڣ�2017��1��11���ں��ս�
 * ������NewsAction   �̳�BaseAction�࣬ʵ��java.io.Serializable  ���л�
 * ���ԣ�NewsBean�����news,newsbean  ��typeid��newsidid��List���͵�loginnewsList
 * ������
 * ��1��
 * ��һ���ƻܣ�UpdateNews�޸ķ���  �� DeleteNewsByIdɾ��������SelectNewsById��ѯ����������SelectNews��ѯ����������Ϣ����
 * ��������ΰ�᣺loadNews��ѯ������exe()�����Ϣ������addNews������ŷ���
 * ��2���������Ե�get��set����
 * */
public class NewsAction extends BaseAction implements java.io.Serializable{
	private NewsBean news,newsbean;//��ȡ�ƻ�����ģ��
	private int typeid;
	private int newsidid;
	private List<NewsBean> loginnewsList;
	//------------0111ΰ��--------------
	private NewsService newsService = new NewsServiceImpl();//ΰ���ѯ
	String pubtime = new SimpleDateFormat("yyyy-MM-dd HH:MM").format(Calendar.getInstance().getTime());
	public NewsBean getNewsbean() {
		return newsbean;
	}
   
	public void setNewsbean(NewsBean newsbean) {
		this.newsbean = newsbean;
	}

	public List<NewsBean> getLoginnewsList() {
			return loginnewsList;
	}
		public void setLoginnewsList(List<NewsBean> loginnewsList) {
			this.loginnewsList = loginnewsList;
	}
	public int getNewsidid() {
		return newsidid;
	}
	public void setNewsidid(int newsidid) {
		this.newsidid = newsidid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public NewsBean getNews() {
		return news;
	}
	public void setNews(NewsBean news) {
		this.news = news;
	}
	//�޸����ŷ���
	public String UpdateNews(){
		System.out.println(news);
		NewstypeBean  newsTypebean=new NewstypeBean();
		newsTypebean.setTypeid(typeid);
		news.setNewsTypebean(newsTypebean);
		NewsServiceImpl newsServiceImpl=new NewsServiceImpl();
		news.setPubtime(pubtime);
		boolean flag=newsServiceImpl.changeNews(news);
		System.out.println("�޸ĳɹ�"+flag);	
		NewsServiceImpl newsService=new NewsServiceImpl();
		this.loginnewsList = newsService.getNews("2");
		request.put("loginnewsList", loginnewsList);	
  		ActionContext actionContext = ActionContext.getContext(); 	
		session=(Map) actionContext.get("session"); 
		session.put("loginnewsList", loginnewsList);		
		if(flag)
		return "updatenewssuccess";
		else
			return "updatenewfail";
	}
	//ɾ������id����
	public String DeleteNewsById(){
		NewsService newsServiceImpl=new NewsServiceImpl();
		boolean flag=newsServiceImpl.removeNewsById(newsidid);	
		NewsServiceImpl newsService=new NewsServiceImpl();
		this.loginnewsList = newsService.getNews("2");	
		ActionContext actionContext = ActionContext.getContext(); 
		request.put("loginnewsList", loginnewsList);
		session=(Map) actionContext.get("session"); 
		session.put("loginnewsList", loginnewsList);
		System.out.println("flag:"+flag);
		if(flag)
			return "deletenewssuccess";
		else
			return "deletenewsfail";
	}
	//��ѯ��������
	public String SelectNewsById(){
		NewsServiceImpl newsServiceImpl=new NewsServiceImpl();
		System.out.println("newsidid:"+newsidid);
		NewsBean newsBean=newsServiceImpl.getNewsById(newsidid);
		request.put("newsBean", newsBean);		
		ActionContext actionContext = ActionContext.getContext(); 	
		session=(Map) actionContext.get("session"); 
		session.put("newsBean", newsBean);
		return "SelectNewsById";
	}
	//��ѯ��������
	public String SelectNews(){//---------------------�鿴����
		NewsServiceImpl newsService=new NewsServiceImpl();
		this.loginnewsList = newsService.getNews("2");		
	  		request.put("loginnewsList", loginnewsList);	  		
	  		ActionContext actionContext = ActionContext.getContext(); 		
			session=(Map) actionContext.get("session"); 
			session.put("loginnewsList", loginnewsList);
		return "SelectNews";
	}
	//--------------------------------ΰ��------------------
   //��ҳ��ѯ
	public String loadNews(){
		List<NewsBean> newsList  = newsService.getNews("2");
		request.put("newsList", newsList);
		return "newsList";
	}
	 //�����Ϣ����
	public String exe()  
	{
		NewstypeBean type = new NewstypeBean();
		type.setTypeid(typeid);
		NewsBean news = new NewsBean(0,newsbean.getNewstitle(),newsbean.getAuthor(),newsbean.getContent(),pubtime,newsbean.getNewspic());
		news.setNewsTypebean(type);		
		String  result = addNews(news);
		return result;	
	}
	//������ŷ���
	public String addNews(NewsBean r){	
		boolean flag = false;
		flag = newsService.addnews(r);
		if(flag)
			return "addnewssuccess";
		else
			return "addnewsfail";
	}	
}
