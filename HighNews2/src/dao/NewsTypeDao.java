package dao;

import java.util.List;
import java.util.Vector;

import entity.NewstypeBean;
/*模块：新闻类型接口实现方法
 * 组员：冼海源、岑斯云
 * 日期：2017年1月09日
 * 类名：NewsTypeDao接口
 * 任务：
 * （一）冼海源：实现查找、添加功能
 * （二）岑斯云： 实现删除、修改功能
 * 属性：无
 * 方法
 * （1）新闻类型信息删除、修改方法
 * （2）添加新闻类型、查询新闻方法
 * */
public interface NewsTypeDao {
	//根据按类型id号单个查找
	 public NewstypeBean selectNewstypeById(int _typeid);    
	//查全部信息
	 public List<NewstypeBean> selectNewstype();  
	 //根据传对象添加新闻类型
     public   boolean  insertnewstype(NewstypeBean r); 
     //根据id删除新闻类型
	 public   boolean  deletenewstypeById(int _typeid); 
	 //根据传对象修改新闻类型
	 public   boolean  updatenewstype(NewstypeBean r);   
}
