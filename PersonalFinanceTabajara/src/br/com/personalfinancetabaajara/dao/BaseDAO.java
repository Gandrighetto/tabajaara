package br.com.personalfinancetabaajara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {

	
	
	protected Connection conn;
	
	// AutoIncrement
		protected Long nextid(Connection conn,String tabela,String nomeID) throws SQLException {

			// Montando o comando
			String comandoSQL = "select nvl(max("+ nomeID +"),0) +1 from " + tabela;
			// Transporte para o bd
			PreparedStatement comando = conn.prepareStatement(comandoSQL);
			// Executar o comando
			ResultSet resultado = comando.executeQuery();
			// Colocando o resultado no registro

			Long nextid = null;
			if (resultado.next()) {

				nextid = resultado.getLong(1);

			}

			return nextid;
		}

		
	//Delete
		protected void delete(Connection conn, Long id, String tabela, String nomeID) throws SQLException{
			//Comando
			String comandoSQL = "delete from " + tabela + " where " + nomeID + " = ?";
			//Transporte bd
			PreparedStatement comando = conn.prepareStatement(comandoSQL);
			comando.setLong(1, id);
			
			comando.executeUpdate();
			
			
		}
		
		
}
