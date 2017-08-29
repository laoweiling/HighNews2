package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
/*模块：BaseAction类
 * */
public class BaseAction implements RequestAware,SessionAware,ApplicationAware , ServletResponseAware ,java.io.Serializable{
	protected Map request;
	protected Map session;
	protected Map application;
	protected HttpServletResponse resp;
	
	public void setServletResponse(HttpServletResponse resp) {
		this.resp = resp;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
		
	}

	public void setSession(Map<String, Object> session) {
		this. session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	private static Gson gson = new Gson();
	/**
	 * 把传入的数据以json格式写会到浏览器, 
	 * @param data
	 */
	public void writeJson(Object data){
		//通过response写会json
		resp.setContentType("application/json");
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			//把数据转为json
			pw.println(gson.toJson(data));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
