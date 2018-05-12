package kr.or.dgit.Coffe.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.Coffe.dto.Product;
import kr.or.dgit.Coffe.dto.Sale;
import kr.or.dgit.Coffe.service.CoffeeService;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class InputScreen extends JFrame implements ActionListener, KeyListener, FocusListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;
	private JTextField tfName;
	private JButton btnPrintSale;
	private JButton btnPrintMargin;
	private JButton btnInput;
	private CoffeeService service;


	public InputScreen() {
		initComponents();
		service = CoffeeService.getInstance();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("입력화면");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("제품코드 : ");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblCode);
		
		tfCode = new JTextField();
		tfCode.addFocusListener(this);
		tfCode.addKeyListener(this);
		tfCode.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfCode.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(tfCode);
		tfCode.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblUnit = new JLabel("제품단가 : ");
		lblUnit.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(lblUnit);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPrice.setColumns(10);
		panel_5.add(tfPrice);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSale = new JLabel("판매수량 : ");
		lblSale.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblSale);
		
		tfSaleCnt = new JTextField();
		tfSaleCnt.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfSaleCnt.setHorizontalAlignment(SwingConstants.RIGHT);
		tfSaleCnt.setColumns(10);
		panel_6.add(tfSaleCnt);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblMargin = new JLabel("마 진 율 : ");
		lblMargin.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblMargin);
		
		tfMarginRate = new JTextField();
		tfMarginRate.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfMarginRate.setHorizontalAlignment(SwingConstants.RIGHT);
		tfMarginRate.setColumns(10);
		panel_7.add(tfMarginRate);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 2, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblName = new JLabel("제 품 명 : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_8.add(lblName);
		
		tfName = new JTextField();
		tfName.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		tfName.setHorizontalAlignment(SwingConstants.RIGHT);
		tfName.setColumns(10);
		tfName.setEditable(false);
		panel_8.add(tfName);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		panel_3.add(btnInput);
		
		btnPrintSale = new JButton("출력1");
		btnPrintSale.addActionListener(this);
		panel_3.add(btnPrintSale);
		
		btnPrintMargin = new JButton("출력2");
		btnPrintMargin.addActionListener(this);
		panel_3.add(btnPrintMargin);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			actionPerformedBtnInput(e);
		}
		if (e.getSource() == btnPrintMargin) {
			actionPerformedBtnPrintMargin(e);
		}
		if (e.getSource() == btnPrintSale) {
			actionPerformedBtnPrintSale(e);
		} 
	}
	protected void actionPerformedBtnPrintSale(ActionEvent e) {
		PrintScreen frame = new PrintScreen(true);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnPrintMargin(ActionEvent e) {
		PrintScreen frame = new PrintScreen(false);
		frame.setVisible(true);
	}
	protected void actionPerformedBtnInput(ActionEvent e) {
		int result = service.insertSale(setInputSale());
		if(result == 1) {
			JOptionPane.showMessageDialog(null, "입력 되었습니다.");
			setTf();
		}else {
			JOptionPane.showMessageDialog(null, "확인하시고 다시 입력해주세요!");
		}
	}
	
	private void setTf() {
		tfCode.setEditable(true);
		tfCode.setText("");
		tfName.setText("");
		tfPrice.setText("");
		tfSaleCnt.setText("");
		tfMarginRate.setText("");
		tfCode.requestFocus();
	}
	private Sale setInputSale() {
		Sale sale = new Sale();
		Product product = new Product();
		product.setCode(tfCode.getText());
		product.setName(tfName.getText());
		
		sale.setProduct(product);
		sale.setPrice(Integer.parseInt(tfPrice.getText()));
		sale.setSaleCnt(Integer.parseInt(tfSaleCnt.getText()));
		sale.setMarginRate(Integer.parseInt(tfMarginRate.getText()));
		return sale;
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tfCode) {
			keyPressedTfCode(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyPressedTfCode(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			getProductByNo();
		}
		if(!(tfName.getText().equals(""))) {
			tfName.setEditable(false);
			tfCode.setEditable(false);
		}else {
			
		}
	}
	private void getProductByNo() {
		Product product = service.selectProductByNo(tfCode.getText());
		tfName.setText(product.getName());
	}
	public void focusGained(FocusEvent e) {
	}
	public void focusLost(FocusEvent e) {
		if (e.getSource() == tfCode) {
			focusLostTfCode(e);
		}
	}
	protected void focusLostTfCode(FocusEvent e) {
		getProductByNo();
	}
}
