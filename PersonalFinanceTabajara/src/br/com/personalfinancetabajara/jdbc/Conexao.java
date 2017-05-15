package br.com.personalfinancetabajara.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	//Atributos
	
	private static Connection conn;
	
	//Connect
	public static Connection getConn () throws SQLException
	{
		if (conn == null||conn.isClosed()) 
		{
			String driver = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String usuario = "aluno";
			String senha = "aluno"; 
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				System.out.println("Driver not found");
			}
			conn = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Connected");
		} 
		
		return conn;
	}
	
	//Disconnect
	public static void disconnect()
	{
		try {
			conn.close();
			conn = null;
			System.out.println("Disconnected");
		} catch (SQLException e) {
			System.out.println("Disconnect Failed");
			e.printStackTrace();
		}
		
	}; 
	
	//Main
	public static void main(String[] args) 
	{
	try {
		Conexao.getConn();
		Conexao.disconnect();
	} catch (SQLException e) {
	    System.out.println("Fail Connection");
		e.printStackTrace();
	}
	}
	
	
}
