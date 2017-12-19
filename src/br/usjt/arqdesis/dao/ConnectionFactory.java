package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	// Obt�m conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost/restaurante?useSSL=false&user=root&password=alunos");
	}

	

}
