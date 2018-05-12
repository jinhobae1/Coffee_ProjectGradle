package kr.or.dgit.Coffe.dao;

import java.sql.SQLException;

import kr.or.dgit.Coffe.dto.Product;

public interface ProductDao{
	public Product selectProductByNo(String code) throws SQLException;
	
	public int insertProduct(Product product) throws SQLException;
	public int updateProduct(Product product) throws SQLException;
	public int deleteProduct(Product product) throws SQLException;
}
