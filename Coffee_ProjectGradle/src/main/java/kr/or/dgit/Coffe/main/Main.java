package kr.or.dgit.Coffe.main;

import java.awt.EventQueue;

import kr.or.dgit.Coffe.ui.InputScreen;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					InputScreen frame = new InputScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
