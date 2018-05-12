package kr.or.dgit.Coffe.ui;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffe.service.CoffeeService;
import kr.or.dgit.Coffe.ui.table.AbstractTablePanel;
import kr.or.dgit.Coffe.ui.table.SaleDetailTablePanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PrintScreen extends JFrame {
	private JPanel contentPane;
	private JLabel lblTitle;
	private boolean flag;
	
	public PrintScreen() {
		initComponents();
	}
	
	public PrintScreen(boolean flag) {
		this.flag = flag;
		initComponents();
	}



	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblTitle = new JLabel();
		
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		
		Map<String, Boolean> map = new HashMap<>();
		map.put("isSalePrice", flag);
		
		AbstractTablePanel salePriceRankTable = new SaleDetailTablePanel(flag);
		contentPane.add(salePriceRankTable);
		salePriceRankTable.loadData(CoffeeService.getInstance().callSaleDetail(map));
		
		lblTitle.setText(flag?"판 매 금 액 순 위":"마 진 액 순 위");
		
	}

}
