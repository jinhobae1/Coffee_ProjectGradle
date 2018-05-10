package kr.or.dgit.erp_application.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DBCon {
	private static final DBCon instance = new DBCon();
	
	private Connection connection;
	
	public static DBCon getInstance() {
		return instance;
	}

	private DBCon() {
		try {
			LoadProperties pro = new LoadProperties();
			Properties info = pro.getProperties();
			connection = DriverManager.getConnection(info.getProperty("url"), info);
		} catch (SQLException e) {
			System.err.printf("%s = %s%n", e.getMessage(), e.getErrorCode());
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void connectionClose() {
		try {
			connection.close();
			JOptionPane.showMessageDialog(null, "연결 해제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
