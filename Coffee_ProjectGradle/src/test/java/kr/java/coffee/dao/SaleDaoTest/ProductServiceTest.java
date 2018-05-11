package kr.java.coffee.dao.SaleDaoTest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.Coffe.dto.Product;
import kr.or.dgit.Coffe_service.ProductService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {
	private static ProductService productService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		productService = ProductService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		productService = null;
	}
	
	@Before
	public void setup()throws Exception{
		System.out.println("setUP");
	}
	
	@After
	public void tearDow()throws Exception{
		testAselectProdictByAll();
	}

	@Test
	public void testAselectProdictByAll() {
		List<Product> pdtLists = productService.selectProductAll();
		Assert.assertNotEquals(0, pdtLists.size());
	}
	
	@Test
	public void testBselectProductByNo() {
		Product product = productService.selectProductByNo(new Product("A001"));
		Assert.assertNotEquals("A001", product.getPrdName());
	}
	
	@Test
	public void testCinsertProduct() {
		Product newProduct = new Product("A005","캬라멜마키아또");
		int res = productService.insertProduct(newProduct);
		Assert.assertEquals(1,res);
	}
	

	@Test
	public void testDupdateProduct() {
		Product updateProduct = new Product("A005","홍차");
		int res = productService.updateProduct(updateProduct);
		Assert.assertEquals(1,res);
	}
	

	@Test
	public void testEdeleteProduct() {
		Product deleteProduct = new Product("A005");
		int res = productService.deleteProduct(deleteProduct);
		Assert.assertEquals(1,res);
	}

}
