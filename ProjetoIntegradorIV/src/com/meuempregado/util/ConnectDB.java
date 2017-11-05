package com.meuempregado.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private String driver =  "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
    private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=IntegradorIV";
	private String usuario = "ThiagoSouza";
	private String senha = "12345678";//jugative
	public Connection con;
	
	public Connection getConnection() throws SQLException {// throws MyClassException
		try {
			Connection con;
			Class.forName(driver);
			//System.setProperty("com.microsoft.sqlserver.jdbc.SQLServerDriver", driver);
			con = DriverManager.getConnection(caminho,usuario,senha);
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não deu certo");
			return null;
		}
	}	
}
