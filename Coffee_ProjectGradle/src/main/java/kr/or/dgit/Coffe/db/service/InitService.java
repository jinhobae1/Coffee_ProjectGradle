package kr.or.dgit.Coffe.db.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import kr.or.dgit.Coffe.db.dao.ExecuteSql;

public class InitService implements DaoService {

	private static final InitService instance = new InitService();
	
	public static InitService getInstance() {
		return instance;
	}
	
	private InitService() {}
	
	@Override
	public void service() {
		File f1 = new File(System.getProperty("user.dir") + "\\resources\\create_sql.txt");
		File f2 = new File(System.getProperty("user.dir") + "\\resources\\proc_sql.txt");
		try(BufferedReader br1 = new BufferedReader(new FileReader(f1));BufferedReader br2 = new BufferedReader(new FileReader(f2));) {
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br1.readLine()) != null) {	//파일문장 전체 읽기
				if(!line.isEmpty() && !line.startsWith("--")) {
					sb.append(line);
				}
				if(line.endsWith(";")) {
					ExecuteSql.getIntance().execSQL(sb.toString());
					sb.setLength(0);
				}
			}
			while((line = br2.readLine()) != null) {	//파일문장 전체 읽기
				if(!line.isEmpty() && !line.startsWith("--")) {
					sb.append(line);
				}
				if(line.endsWith("end;")) {
					ExecuteSql.getIntance().execSQL(sb.toString());
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
