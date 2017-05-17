package br.com.personalfinancetabaajara.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.personalfinancetabajara.model.Gastos;
import br.com.personalfinancetabajara.util.AppUtil;

public class GastosDAO extends BaseDAO {

	private static GastosDAO instancia;

	public static final GastosDAO getInstancia(Connection conn) {
		if (instancia == null) {
			instancia = new GastosDAO(conn);
		}
		return instancia;
	}

	private GastosDAO(Connection conn) {
		this.conn = conn;
	}

	// Salvar
	public void salvar(Gastos gasto) throws SQLException, NoSuchAlgorithmException {
		// Montando o comando
		String comandoSQL = "insert into gastos (id_gastos, descricao, valor, dt_gasto) values (?, ?, ?, ?)";
		// Transporte para bd
		PreparedStatement comando = conn.prepareStatement(comandoSQL);
		// Prencher os valores
		comando.setLong(1, nextid(conn, "gastos", "id_gastos"));
		comando.setString(2, gasto.getDescricao());
		comando.setDouble(3, gasto.getValor());
		comando.setDate(4, AppUtil.dateUtilToDateSql(gasto.getData()));
		// Executar o comando
		comando.executeUpdate();

	}

	// Update

	public void update(Gastos gasto) throws SQLException, NoSuchAlgorithmException {
		// Comando SQL
		String comandoSQL = "update gastos set descricao = ?, valor = ?, dt_gasto = ? where id_gastos = ?";
		// Transporte bd
		PreparedStatement comando = conn.prepareStatement(comandoSQL);
		// set novos valores
		comando.setString(1, gasto.getDescricao());
		comando.setDouble(2, gasto.getValor());
		comando.setDate(3, AppUtil.dateUtilToDateSql(gasto.getData()));
		comando.setLong(4, gasto.getId());
		// executar o comando
		comando.executeUpdate();
		//

	}

	// Select pelo id
	public Gastos load(Long id) throws SQLException {
		// Comando SQL
		String comandoSQL = "select id_gastos, descricao, valor, dt_gasto from gastos where id_gastos = ?";
		// transporte bd
		PreparedStatement comando = conn.prepareStatement(comandoSQL);
		//
		comando.setLong(1, id);
		//
		comando.executeQuery();
		//
		ResultSet resultado = comando.executeQuery();
		Gastos gasto = null;
		if (resultado.next()) {

			gasto = new Gastos(resultado.getString("descricao"), resultado.getDouble("valor"),
					resultado.getDate("dt_gasto"));
			gasto.setId(id);
		}

		return gasto;

	}
	// List gastos
	public ArrayList<Gastos> list() throws SQLException {
		// Comando SQL
		String comandoSQL = "select id_gastos, descricao, valor, dt_gasto from gastos";
		// transporte bd
		PreparedStatement comando = conn.prepareStatement(comandoSQL);
		//
		comando.executeQuery();
		//
		ResultSet resultado = comando.executeQuery();
		ArrayList<Gastos> list = new ArrayList<Gastos>();
		while(resultado.next()) {

			Gastos gasto = new Gastos(resultado.getString("descricao"), resultado.getDouble("valor"),
					resultado.getDate("dt_gasto"));
			gasto.setId(resultado.getLong("id_gastos"));
			
			list.add(gasto);
		}

		return list;
	
	}
	
	public void remover(Long id) throws SQLException{
		delete(conn, id, "gastos", "id_gastos");
		
	}
	
	
	

	
	
	
	
}
