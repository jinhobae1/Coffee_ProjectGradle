package kr.or.dgit.Coffe_proj;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UiCoffeMain extends JFrame {
	public UiCoffeMain() {
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiCoffeProCode frame = new UiCoffeProCode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
