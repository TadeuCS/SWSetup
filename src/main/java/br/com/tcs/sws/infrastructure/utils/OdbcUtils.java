package br.com.tcs.sws.infrastructure.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class OdbcUtils {
	
	public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/mysql?useTimezone=true&serverTimezone=UTC", "metre", "durama@357");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
