package action;

import com.opensymphony.xwork2.ActionSupport;
/*模块：跳转页面模块
 * 组员：黄卉
 * 功能：跳转添加新闻页面、跳转删除、修改、查询新闻页面
 * 日期：2017年1月10日终结  
 * 类名：ResourceAction   继承ActionSupport类，实现java.io.Serializable
 * 属性：method（jsp通过URL传来的参数）
 * 方法
 * （1）method的get和set方法 
 * （2）execute方法，通过action判断操作
 * */
public class ResourceAction extends ActionSupport implements java.io.Serializable{
	private String method;//jsp传参
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	//如果点击add则跳转添加新闻页面，否则跳转查询所有新闻的主页
	public String execute(){
		System.out.println(method);
		if(method.equals("add")){
			return "addtab";
		}
		else{	
			return "admintab";
		}
	}
}
