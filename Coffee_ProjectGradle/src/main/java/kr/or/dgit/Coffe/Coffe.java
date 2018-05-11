package kr.or.dgit.Coffe;
public class Coffe {
	private int CffNo;
	private String CffName;
	private int Cffprice;
	private int CffSNum;
	private int CffMar;
	
	
	
	public Coffe() {
		// TODO Auto-generated constructor stub
	}



	public Coffe(int cffNo, String cffName, int cffprice, int cffSNum, int cffMar) {
		CffNo = cffNo;
		CffName = cffName;
		Cffprice = cffprice;
		CffSNum = cffSNum;
		CffMar = cffMar;
	}



	public int getCffNo() {
		return CffNo;
	}



	public void setCffNo(int cffNo) {
		CffNo = cffNo;
	}



	public String getCffName() {
		return CffName;
	}



	public void setCffName(String cffName) {
		CffName = cffName;
	}



	public int getCffprice() {
		return Cffprice;
	}



	public void setCffprice(int cffprice) {
		Cffprice = cffprice;
	}



	public int getCffSNum() {
		return CffSNum;
	}



	public void setCffSNum(int cffSNum) {
		CffSNum = cffSNum;
	}



	public int getCffMar() {
		return CffMar;
	}



	public void setCffMar(int cffMar) {
		CffMar = cffMar;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CffMar;
		result = prime * result + ((CffName == null) ? 0 : CffName.hashCode());
		result = prime * result + CffNo;
		result = prime * result + CffSNum;
		result = prime * result + Cffprice;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coffe other = (Coffe) obj;
		if (CffMar != other.CffMar)
			return false;
		if (CffName == null) {
			if (other.CffName != null)
				return false;
		} else if (!CffName.equals(other.CffName))
			return false;
		if (CffNo != other.CffNo)
			return false;
		if (CffSNum != other.CffSNum)
			return false;
		if (Cffprice != other.Cffprice)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return String.format("Coffe [CffNo=%s, CffName=%s, Cffprice=%s, CffSNum=%s, CffMar=%s]", CffNo, CffName,
				Cffprice, CffSNum, CffMar);
	}

	
	

}
