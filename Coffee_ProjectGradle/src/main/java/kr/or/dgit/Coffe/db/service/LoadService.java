package kr.or.dgit.Coffe.db.service;

import java.util.Properties;

import kr.or.dgit.Coffe.db.dao.ExecuteSql;
import kr.or.dgit.Coffe.db.jdbc.LoadProperties;

public class LoadService implements DaoService{
	private static final LoadService instance = new LoadService();
	
	public static LoadService getInstence() {
		return instance;
	}

	private LoadService() {}

	@Override
	public void service() {
		LoadProperties loadProperties = new LoadProperties();
		Properties properties = loadProperties.getProperties();
		ExecuteSql.getIntance().execSQL("use " + properties.getProperty("dbname"));
		ExecuteSql.getIntance().execSQL("set foreign_key_checks=0");
		String[] tables = properties.get("tables").toString().split(",");
		for(String tblName : tables) {
			String sql = getPath(tblName);
			ExecuteSql.getIntance().execSQL(sql);
		}
		ExecuteSql.getIntance().execSQL("set foreign_key_checks=1");
	}

	private String getPath(String tblName) {
		String path = String.format("%s/DataFiles/%s.txt",System.getProperty("user.dir"),tblName);
		String sql = String.format("load data local infile '%s' into table %s character set 'utf8' fields terminated by ',';",path, tblName);
		sql = sql.replace("\\", "/");
		System.out.println(sql);
		return sql;
	}

}




