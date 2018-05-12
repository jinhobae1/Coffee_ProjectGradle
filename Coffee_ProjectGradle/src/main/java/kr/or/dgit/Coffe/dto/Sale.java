package kr.or.dgit.Coffe.dto;

public class Sale {
	private int no;
	private Product product;
	private int price;
	private int saleCnt;
	private int marginRate;
	
	public Sale() {
	}
		
	public Sale(int no, Product product, int price, int saleCnt, int marginRate) {
		this.no = no;
		this.product = product;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSaleCnt() {
		return saleCnt;
	}
	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}
	public int getMarginRate() {
		return marginRate;
	}
	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}
	
	@Override
	public String toString() {
		return String.format("Sale [no=%s, product=%s, price=%s, saleCnt=%s, marginRate=%s]", no, product, price,
				saleCnt, marginRate);
	}
		
}
