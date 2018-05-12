package kr.or.dgit.Coffe.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.dgit.Coffe.dto.Rank;
import kr.or.dgit.Coffe.dto.Sale;

public interface SaleDao {
	public List<Sale> selectSaleByAll() throws SQLException;
	public List<Sale> selectSaleByNo(Sale sale) throws SQLException;
	public int insertProduct(Sale sale) throws SQLException;
	public int updateProduct(Sale sale) throws SQLException;
	public int deleteProduct(Sale sale) throws SQLException;
	public List<Rank> callSaleDetail(Map<String, Boolean> map) throws SQLException;
	public List<Rank> getTotal() throws SQLException;
	
}
