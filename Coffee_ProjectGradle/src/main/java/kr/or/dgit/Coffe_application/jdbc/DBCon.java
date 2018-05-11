package kr.or.dgit.Coffe_application.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private String dbName;
	private Connection connection;
	private Properties properties;

	public static DBCon getInstance() {
		return instance;
	}

	private DBCon() {
	}

	public Connection getConnection() {
		return connection;
	}

	public void connectionClose() {
		if (connection != null) {
			try {
				connection.close();
				JOptionPane.showMessageDialog(null, "연결 해제되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getDbName() {
		return dbName;
	}

	public Properties getProperties() {
		return properties;
	}

	public Connection getConnection(String propPath) {
		Properties properties = new Properties();
		try (InputStream is = ClassLoader.getSystemResourceAsStream(propPath)) {
			properties.load(is);
			dbName = properties.getProperty("dbname");
			connection = DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (SQLException e) {
			System.err.printf("%s = %s%n", e.getMessage(), e.getErrorCode());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
