package kr.or.dgit.Mybatis_study.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory SqlSessionFactory;
 
	public static SqlSessionFactory getSqlSessionFactory() {
		if(SqlSessionFactory==null) {
			InputStream inputstream;
			try {
				inputstream=Resources.getResourceAsStream("mybatis_config.xml");
				SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
			}catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getCause());
			}
		}
		return SqlSessionFactory;
	}
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}
