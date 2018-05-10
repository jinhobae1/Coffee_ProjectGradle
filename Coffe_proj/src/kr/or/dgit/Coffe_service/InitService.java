package kr.or.dgit.Coffe_service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import kr.or.dgit.Coffe_application.jdbc.DBCon;
import kr.or.dgit.dao.ExecuteSql;


public class InitService implements DaoService {
	private static final InitService instance = new InitService();

	public static InitService getInstance() {
		return instance;
	}

	private InitService() {
	}

	@Override
	public void service() {
		createTable();
		createTriggerOrProcedure(); // 프로시저생성
	}

	private void createTriggerOrProcedure() {
		File f = new File(System.getProperty("user.dir") + "\\Data\\create_trigger_procedure.txt");
		String dbName = (String) DBCon.getInstance().getProperties().get("dbname");
		ExecuteSql.getInstance().execSQL("use " + dbName);
		if (!f.exists()) {
			return;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			StringBuilder statement = new StringBuilder();
			for (String line; (line = br.readLine()) != null;) {
				if (!line.isEmpty() && !line.startsWith("--")) {
					statement.append(line);
				}
				if (line.endsWith("END;")) {
					ExecuteSql.getInstance().execSQL(statement.toString());
					statement.setLength(0);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createTable() {
		File f = new File(System.getProperty("user.dir") + "\\Data\\create_sql.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(f));) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty() && !line.startsWith("--")) {
					sb.append(line);
				}
				if (line.endsWith(";")) {
					ExecuteSql.getInstance().execSQL(sb.toString());
					sb.setLength(0);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}