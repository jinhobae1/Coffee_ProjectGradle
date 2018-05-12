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
public class ProductServiceTest {
	private static CoffeeService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = CoffeeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	/*@Test
	public void testAselectByAll() {
		List<Sale> list = service.selectSaleByAll();
	}
	
	@Test
	public void testCInsertProduct() {
		Product product = new Product();
		product.setCode("A001");
		Sale sale = new Sale();
		sale.setProduct(product);
		sale.setPrice(2500);
		sale.setSaleCnt(50);
		sale.setMarginRate(10);
		int result = service.insertProduct(sale);
		Assert.assertEquals(1, result);
	}*/
	
	/*@Test
	public void testDupdateProduct() {
		Product product = new Product();
		product.setCode("A003");
		product.setName("카라멜막부어또");
		int result = service.updateProduct(product);
		Assert.assertEquals(1, result);
	}
	@Test
	public void testEdeleteProduct() {
		Product product = new Product();
		product.setCode("A003");
		product.setName("카라멜막부어또");
		int result = service.deleteProduct(product);
		Assert.assertEquals(1, result);
	}*/
	
	@Test
	public void testFcallSaleDetail() {
		Map<String, Boolean> map = new HashMap<>();
		map.put("isSalePrice", true);
		List<Rank> rank = service.callSaleDetail(map);
	}
}
