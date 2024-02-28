package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	// 쿼리를 실행하기 위한 session을 생성.
		public static SqlSessionFactory getInstance() {
			String resource = "config/mybatis-config.xml"; //태그, 기능
			InputStream inputStream = null;
			
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// session 을 반환해주는 기능을 만들기 위해서 sqlSessionFactory 만듦.
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			return sqlSessionFactory;
		}

}
