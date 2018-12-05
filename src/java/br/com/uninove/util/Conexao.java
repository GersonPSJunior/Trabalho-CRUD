package br.com.uninove.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	public static Connection abrirConexao(){
		
		Connection con = null;
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/uninove";
			con = DriverManager.getConnection(url, "root", "");
			System.out.print("Conexao aberta!");
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void FecharConexao(Connection con) {
		
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
