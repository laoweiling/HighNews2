package service;

import java.util.List;

import entity.NewstypeBean;
/*模块：新闻类型业务逻辑层处理
 * 组员：选海源、岑斯云
 * 日期：2017年1月10日组合终结
 * 类名：NewsTypeService接口
 * 任务：
 * （一）岑斯云：实现删除新闻、修改新闻业务逻辑处理接口
 * （二）选海源： 实现添加新闻接口、查询新闻接口
 * 方法
 * （1）新闻类型信息删除、修改类型方法
 * （2）添加新闻类型、查询新闻类型方法
 * */
public interface NewsTypeService {
	  //按类型号查找类型号查找
	 public NewstypeBean getNewsTypeById(int _typeid); 
	//查询所有新闻类型
	 public List<NewstypeBean> getNewsType();  
	 //增加新闻类型
	 public   boolean  addNewsType(NewstypeBean r);   
	  //删除新闻类型
	 public   boolean  removeNewsTypeById(int _typeid); 
	 //修改新闻类型
	 public   boolean  changeNewsType(NewstypeBean r);   

}
