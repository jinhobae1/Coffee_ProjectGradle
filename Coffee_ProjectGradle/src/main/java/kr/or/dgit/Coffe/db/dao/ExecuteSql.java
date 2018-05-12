package kr.or.dgit.Coffe.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.dgit.Coffe.db.jdbc.DBCon;

public class ExecuteSql {
	private static final ExecuteSql instance = new ExecuteSql();
	
	public static ExecuteSql getIntance() {
		return instance;
	}

	private ExecuteSql() {}
	
	public void execSQL(String sql) {
		System.out.println(sql);
		Connection con = DBCon.getInstance().getConnection();
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(sql);
			System.out.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	public ResultSet execQuerySQL(String sql) throws SQLException {
		Connection con = DBCon.getInstance().getConnection();
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		
		return pstmt.executeQuery();
	}
	
}
