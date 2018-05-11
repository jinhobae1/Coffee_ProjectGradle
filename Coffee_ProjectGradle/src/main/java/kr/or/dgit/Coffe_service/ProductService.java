package kr.or.dgit.Coffe_service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.dgit.Coffe.dto.Product;
import kr.or.dgit.Mybatis_study.util.MybatisSqlSessionFactory;

public class ProductService {
	private static final Log log = LogFactory.getLog(ProductService.class);

	private static final ProductService instance = new ProductService();
	private String namespace = "kr.or.dgit.Coffe.dao.ProductDao";
	private SqlSessionFactory sessionFactory;

	private ProductService() {
		sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}

	public static ProductService getInstance() {
		return instance;
	}

	public List<Product> selectProductAll() {
		log.debug("selectProductAll()");
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectProductByNo");
		}
	}
	
	public Product selectProductByNo(Product product) {
		log.debug("selectProductByNo()");
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectProductByNo",product);
		}
	}

	public int insertProduct(Product product) {
		log.debug("insertProduct()");
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertProduct", product);
			sqlSession.commit();
			return res;
		}
	}

	public int deleteProduct(Product product) {
		log.debug("deleteProduct()");
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + ".deleteProduct", product);
			sqlSession.commit();
			return res;
		}
	}

	public int updateProduct(Product product) {
		log.debug("updateProduct()");
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			int res = sqlSession.update(namespace + ".updateProduct", product);
			sqlSession.commit();
			return res;
		}
	}

}
