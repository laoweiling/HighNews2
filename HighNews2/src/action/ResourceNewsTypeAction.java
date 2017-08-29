package action;

import com.opensymphony.xwork2.ActionSupport;
/*模块：新闻类别跳转页面模块（左则）
 * 组员：劳伟玲
 * 功能：跳转添加、删除、修改、查询新闻类型页面
 * 日期：2017年1月11日下午终结  
 * 类名：ResourceNewsTypeAction   继承ActionSupport类，实现java.io.Serializable
 * 属性：method（jsp通过URL传来的参数）
 * 方法
 * （1）method的get和set方法 （参照新闻的resource方法）
 * （2）execute方法，通过action判断操作
 * */
public class ResourceNewsTypeAction extends ActionSupport implements java.io.Serializable{
	private String method;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	//跳转页面
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
