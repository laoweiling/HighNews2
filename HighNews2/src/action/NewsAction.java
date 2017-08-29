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
/*模块：新闻模块
 * 功能：增加新闻、删除新闻、修改新闻、单个查询新闻以及多个查询新闻
 * 组员：黄卉  劳伟玲
 * 工作分配：（一）查询新闻、添加新闻（劳伟玲）  （二）删除新闻与修改新闻（黄卉）
 * 日期：2017年1月11日融合终结
 * 类名：NewsAction   继承BaseAction类，实现java.io.Serializable  序列化
 * 属性：NewsBean对象的news,newsbean  ，typeid，newsidid，List类型的loginnewsList
 * 方法：
 * （1）
 * （一）黄卉：UpdateNews修改方法  、 DeleteNewsById删除方法、SelectNewsById查询单个方法、SelectNews查询所有新闻信息方法
 * （二）劳伟玲：loadNews查询方法、exe()添加信息方法，addNews添加新闻方法
 * （2）所有属性的get和set方法
 * */
public class NewsAction extends BaseAction implements java.io.Serializable{
	private NewsBean news,newsbean;//获取黄卉新闻模块
	private int typeid;
	private int newsidid;
	private List<NewsBean> loginnewsList;
	//------------0111伟玲--------------
	private NewsService newsService = new NewsServiceImpl();//伟玲查询
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
	//修改新闻方法
	public String UpdateNews(){
		System.out.println(news);
		NewstypeBean  newsTypebean=new NewstypeBean();
		newsTypebean.setTypeid(typeid);
		news.setNewsTypebean(newsTypebean);
		NewsServiceImpl newsServiceImpl=new NewsServiceImpl();
		news.setPubtime(pubtime);
		boolean flag=newsServiceImpl.changeNews(news);
		System.out.println("修改成功"+flag);	
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
	//删除新闻id方法
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
	//查询单个新闻
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
	//查询所有新闻
	public String SelectNews(){//---------------------查看新闻
		NewsServiceImpl newsService=new NewsServiceImpl();
		this.loginnewsList = newsService.getNews("2");		
	  		request.put("loginnewsList", loginnewsList);	  		
	  		ActionContext actionContext = ActionContext.getContext(); 		
			session=(Map) actionContext.get("session"); 
			session.put("loginnewsList", loginnewsList);
		return "SelectNews";
	}
	//--------------------------------伟玲------------------
   //分页查询
	public String loadNews(){
		List<NewsBean> newsList  = newsService.getNews("2");
		request.put("newsList", newsList);
		return "newsList";
	}
	 //添加信息方法
	public String exe()  
	{
		NewstypeBean type = new NewstypeBean();
		type.setTypeid(typeid);
		NewsBean news = new NewsBean(0,newsbean.getNewstitle(),newsbean.getAuthor(),newsbean.getContent(),pubtime,newsbean.getNewspic());
		news.setNewsTypebean(type);		
		String  result = addNews(news);
		return result;	
	}
	//添加新闻方法
	public String addNews(NewsBean r){	
		boolean flag = false;
		flag = newsService.addnews(r);
		if(flag)
			return "addnewssuccess";
		else
			return "addnewsfail";
	}	
}
