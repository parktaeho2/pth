package org.com.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectTest {
	private static final String DRIVER=
			"oracle.jdbc.driver.OracleDriver";
	private static final String URL=
			"jdbc:oracle:thin:@192.168.0.247:1521:mrealk";
	private static final String User="pdauser";
	private static final String PW="kdexp";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection con =DriverManager.getConnection(URL,User,PW)){
			System.out.println(con);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
