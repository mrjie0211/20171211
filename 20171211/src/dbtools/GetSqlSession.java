package dbtools;

import java.io.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSession {

	public static SqlSession getSqlSession() throws IOException{
		String resource="mybatis-config.xml";
		InputStream inputStream=
				Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSsession=sqlSessionFactory.openSession();
		return sqlSsession;
	}
}
