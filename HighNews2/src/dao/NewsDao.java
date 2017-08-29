package dao;


import java.util.List;
import entity.NewsBean;
/*模块：新闻接口
 * 组员：黄卉、劳伟玲
 * 日期：2017年1月11日组合终结
 * 类名：NewsDao接口
 * 任务：
 * （一）黄卉：实现删除新闻接口、修改新闻接口
 * （二）劳伟玲： 实现添加新闻接口、查询新闻接口、分页接口方法
 * 属性：无
 * 方法
 * （1）新闻信息删除、修改方法
 * （2）添加新闻、查询新闻方法
 * （3）分页实现方法
 * */
public interface NewsDao {
	//插入用户方法，传对象参数
	public boolean insertNews(NewsBean nB);
	//查询单个新闻信息，id传参
	public NewsBean selectNewsById(int _newsid);  
	//查询全部新闻信息，传参标识
	public List<NewsBean> selectNews(String select_type);   
	//删除单条新闻
	public boolean  deleteNewsById(int _newsid); 
	//修改新闻信息接口方法
	public  boolean  updateNews(NewsBean nB);   
	//（分页方法）
	public List<NewsBean> pagenationDao();

}



