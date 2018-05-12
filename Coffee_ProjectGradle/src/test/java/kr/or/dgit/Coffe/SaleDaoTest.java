package kr.or.dgit.Coffe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.Coffe.dto.Product;
import kr.or.dgit.Coffe.dto.Rank;
import kr.or.dgit.Coffe.dto.Sale;
import kr.or.dgit.Coffe.service.CoffeeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SaleDaoTest {
	private static CoffeeService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = CoffeeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	
	@Test
	public void testAselectSaleByAll() {
		List<Sale> list = service.selectSaleByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void testBselectSaleByNo() {
		List<Sale> sale = service.selectSaleByNo("A001");
		Assert.assertNotNull(sale);
	}
	
	@Test
	public void testCinsertProduct() {
		Product product = new Product();
		product.setCode("B005");
		product.setName("폭탄초코");
		int result = service.insertProduct(product);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testDupdateProduct() {
		Product product = new Product();
		product.setCode("B005");
		product.setName("핵폭탄 초코");
		int result = service.updateProduct(product);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testEdeleteProduct() {
		Product product = new Product();
		product.setCode("B005");
		product.setName("핵폭탄 초코");
		int result = service.deleteProduct(product);
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testFcallSaleDetail() {
		Map<String, Boolean> map = new HashMap<>();
		map.put("isSalePrice", true);
		List<Rank> rank = service.callSaleDetail(map);
		Assert.assertNotNull(rank);
	}
	
	@Test
	public void testGcallgetTotal() {
		List<Map<String, Object>> res = service.getTotal();
		Assert.assertNotNull(res);
	}
}
