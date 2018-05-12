package kr.or.dgit.Coffe.ui.table;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;

import kr.or.dgit.Coffe.dto.Rank;
import kr.or.dgit.Coffe.service.CoffeeService;

@SuppressWarnings("serial")
public class SaleDetailTablePanel extends AbstractTablePanel {
	
	public SaleDetailTablePanel() {}

	public SaleDetailTablePanel(boolean isSalePrice) {
		super(isSalePrice?"판 매 금 액 순 위":"마 진 액 순 위");
	}

	@Override
	protected void setAlignWith() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(100, 100, 150, 100, 100, 150, 150, 150, 100, 150);
	}
	
	@Override
	protected Object[][] toArray(List<Rank> items) {
		Object[][] results = new Object[items.size()+1][];
		for(int i=0;i<items.size();i++) {
			results[i] = items.get(i).toArray();
		}
		results[items.size()] = getTotal();
		return results;
	}
	

	private Object[] getTotal() {
		List<Map<String, Object>> res = CoffeeService.getInstance().getTotal();
		Map<String, Object> maps = res.get(0);
		String[] total = new String[10];
		
		total[0] = "합계";
		Arrays.fill(total, 1, 4, "");
		total[5] = String.format("%,.0f", maps.get("supply_price"));
		total[6] = String.format("%,.0f", maps.get("addtax_price"));
		total[7] = String.format("%,.0f", maps.get("sale_price"));
		total[8] = "";
		total[9] = String.format("%,.0f", maps.get("margin_price"));
		
		return total;
	}

	@Override
	protected void setColumnNames() {
		colNames = new String[] {
				"순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액"
		};

	}

}
