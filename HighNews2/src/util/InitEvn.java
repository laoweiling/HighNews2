package util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

//初始化环境工具类
public class InitEvn {
	public static void main(String[] args) {
		//Hibernate的配置类对象,用于创建SessionFactory.
		Configuration conf = new Configuration().configure();	
		SchemaExport se = new SchemaExport(conf);		
		//正向工程  (是否显示脚本, 是否执行脚本)
		se.create(true, true);
	}
}
