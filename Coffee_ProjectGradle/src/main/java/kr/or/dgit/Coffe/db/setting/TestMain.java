package kr.or.dgit.Coffe.db.setting;

import java.util.Map.Entry;

import kr.or.dgit.Coffe.db.jdbc.DBCon;
import kr.or.dgit.Coffe.db.jdbc.LoadProperties;

import java.util.Properties;

public class TestMain {
	public static void main(String[] args) {
		testDBConnection();
	}
	
	private static void testDBConnection() {
		DBCon dbCon = DBCon.getInstance();
		System.out.println(dbCon);
		
		LoadProperties lp = new LoadProperties();
		Properties pro = lp.getProperties();
		
		for(Entry<Object,Object> e: pro.entrySet()) {
			System.out.printf("%s : %s%n", e.getKey(), e.getValue());
		}
		
	}
}
