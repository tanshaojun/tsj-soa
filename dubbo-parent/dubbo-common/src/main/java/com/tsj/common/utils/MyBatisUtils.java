package com.tsj.common.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBatisUtils {
	
	private MyBatisUtils(){}//建立构造方法  
    private static final String resource="spring-context.xml";//配置文件名称用常量标示  
    private static SqlSessionFactory sqlsf=null;//建立sqlsession工厂  
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();//建立本地线程  
    ////创建线程局部变量threadLocal，用来保存Mybatis的threadLocal  

    static{//静态与，加载时执行一次，在类初始化之前实现  
    	ApplicationContext atx = new ClassPathXmlApplicationContext(resource);
    	sqlsf = (SqlSessionFactory)atx.getBean("sqlSessionFactory");
       
    }  
      
      
    public static SqlSessionFactory getSqlSessionFactory(){  
        return sqlsf;  
    }  
    //獲取session
    public static SqlSession getSession(){  
        SqlSession session=threadLocal.get();//得到线程当前的SqlSession  
        //可以保证每个线程对应一个数据对象，在任何时刻都操作的是这个对象。   
        if(session==null){  
            session=sqlsf.openSession();//建立SqlSession  
            threadLocal.set(session);//将新建立的SqlSession放在本地线程中  
        }  
        return session;  
    }  
  
    //關閉session
    public static void closeSession(){  
        SqlSession session=threadLocal.get();//得到本地线程中的SqlSession  
        threadLocal.set(null);//设置本地线程threadLocal为空  
        if (session !=null){  
            session.close();  
        }  
    }  
    //提交session
    public static void commitSession(){  
    	SqlSession session=threadLocal.get();//得到本地线程中的SqlSession  
    	if (session !=null){  
    		session.commit();  
    	}  
    }  
    //回滾session
    public static void rollbackSession(){  
    	SqlSession session=threadLocal.get();//得到本地线程中的SqlSession  
    	if (session !=null){  
    		session.rollback();  
    	}  
    }

    public static void remove(){
        threadLocal.remove();
    }
	
}