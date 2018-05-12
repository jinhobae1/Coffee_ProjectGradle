package kr.or.dgit.Coffe.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.Coffe.dao.ProductDao;
import kr.or.dgit.Coffe.dto.Product;
import kr.or.dgit.Coffe.dto.Rank;
import kr.or.dgit.Coffe.dto.Sale;
import kr.or.dgit.Coffe.util.MyBatisSqlSessionFactory;

public class CoffeeService {
	private static final Log log = LogFactory.getLog(ProductDao.class);
	private String productSpace = "kr.or.dgit.ragnarak.dao.ProductDao.";
	private String saleSpace = "kr.or.dgit.ragnarak.dao.SaleDao.";
	private static final CoffeeService instance = new CoffeeService();
	
	public static CoffeeService getInstance() {
		return instance;
	}
	
	private CoffeeService() {}
	
	public Product selectProductByNo(String code){
		log.debug("selectProductByNo()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		Product product = session.selectOne(productSpace + "selectProductByNo", code);
		return product; 
	}
	
	public int insertProduct(Product product) {
		log.debug("insertProduct()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		int result = session.insert(productSpace + "insertProduct",product);
		session.commit();
		return result;
	}
	
	public List<Sale> selectSaleByAll(){
		log.debug("selectSaleByAll()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		return session.selectList(saleSpace + "selectSaleByAll");
	}
	
	public List<Sale> selectSaleByNo(String code){
		log.debug("selectSaleByNo()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		return session.selectList(saleSpace + "selectSaleByNo", code);
	}
	
	public int insertSale(Sale sale) {
		log.debug("insertSale()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		int result = session.insert(saleSpace + "insertSale",sale);
		session.commit();
		return result;
	}
	
	public int updateProduct(Product product) {
		log.debug("updateProduct()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		int result = session.update(productSpace + "updateProduct",product);
		session.commit();
		return result;
	}

	public int deleteProduct(Product product) {
		log.debug("deleteProduct()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		int result = session.delete(productSpace + "deleteProduct",product);
		session.commit();
		return result;
	}
	
	public List<Rank> callSaleDetail(Map<String, Boolean> map){
		log.debug("callSaleDetail()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		return session.selectList(saleSpace + "callSaleDetail", map);
	}

	public List<Map<String, Object>> getTotal() {
		log.debug("getTotal()");
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		return session.selectList(saleSpace + "getTotal");
	}
	
}
