package co.yedam;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	// 쿼리를 실행하기 위한 session 생성.
		public static SqlSessionFactory getInstance() {
			String resource = "config/mybatis-config.xml"; //해당위치의 환경파일을 읽어들여서 쓰겠다는 뜻
			InputStream inputStream = null;
			
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//sql을 쓰기 위해서 Session이 필요한데, 아래 factory가 session을 생성하게 해준다. 위의 환경값들을 불러와서
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
			return sqlSessionFactory;
		}
}
