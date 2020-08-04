package com.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.IMenuDao;
import com.dao.IUserDao;
import com.pojo.User;

public class TestDao {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		SqlSessionFactory sessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
		SqlSession session = sessionFactory.openSession();
		try{
			IMenuDao menudao = session.getMapper(IMenuDao.class);
			System.out.println(menudao.selectAllParentMenus(1));
		}finally{
			session.close();
		}
		
	}

}
