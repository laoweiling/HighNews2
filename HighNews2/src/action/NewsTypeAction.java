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
/*模块：新闻类别模块
 * 组员：岑斯云、冼海源
 * 功能：新闻类别的增加、删除、修改、查询操作
 * 日期：2017年1月9日终结  
 * 类名：NewsTypeAction   继承ActionSupport类，实现java.io.Serializable， RequestAware, SessionAware, ApplicationAware, ModelDriven
 * 属性： NewstypeBean newsTypeBean对象、
 * 用户类usersBean对象get和set方法
 * 方法
 * （1）增删改查方法  
 * （2）属性的get和set方法
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
	//插入新闻类型
	public String InsertNewsType(){
		newsTypeServiceImpl.addNewsType(newsTypeBean);
		return "insert_newsType";
	}
	//修改新闻类型
	public String UpdateNewsType(){
		System.out.println("newsTypeBean用户信息："+newsTypeBean.getTypeid()+" "+newsTypeBean.getTypename());
		newsTypeServiceImpl.changeNewsType(newsTypeBean);
		return "update_newsType";
	}
	//删除新闻类型方法
	public String DeleteNewsTypeById(){
		System.out.println("newsTypeBean用户信息："+newsTypeBean.getTypeid()+" "+newsTypeBean.getTypename());
		newsTypeServiceImpl.removeNewsTypeById(newsTypeBean.getTypeid());
	//	 List<NewstypeBean> allNewsType = newsTypeServiceImpl.getNewsType();
	//	 this.request.put("NewsType", allNewsType);
		return "delete_newsTypeById";
	}
	//查询单个新闻类型信息
	public String SelectNewsTypeById(){
		newsTypeServiceImpl.getNewsTypeById(newsTypeBean.getTypeid());
		return "select_newsTypeById";
	}
	//查询所有新闻类型信息
	public String SelectNewsType(){
		 List<NewstypeBean> allNewsType = newsTypeServiceImpl.getNewsType();
		 this.request.put("NewsType", allNewsType);
		 return "select_newsType";
	}
}
