package kr.or.dgit.Coffe.dto;

public class Rank {
	private int rank;
	private String code;
	private String name;
	private int price;
	private int saleCnt;
	private int supply;
	private int surtax;
	private int selling;
	private int marginRate;
	private int marginPrice;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getSupply() {
		return supply;
	}

	public void setSupply(int supply) {
		this.supply = supply;
	}

	public int getSurtax() {
		return surtax;
	}

	public void setSurtax(int surtax) {
		this.surtax = surtax;
	}

	public int getSelling() {
		return selling;
	}

	public void setSelling(int selling) {
		this.selling = selling;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	public int getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"Rank [rank=%s, code=%s, name=%s, price=%s, saleCnt=%s, supply=%s, surtax=%s, selling=%s, marginRate=%s, marginPrice=%s]",
				rank, code, name, price, saleCnt, supply, surtax, selling, marginRate, marginPrice);
	}

	public Object[] toArray() {
		
		return new Object[] { rank, code, name, String.format("%,3d", price), saleCnt, String.format("%,3d", supply), String.format("%,3d", surtax), String.format("%,3d", selling), marginRate+"%", String.format("%,3d", marginPrice) };
	}

}
