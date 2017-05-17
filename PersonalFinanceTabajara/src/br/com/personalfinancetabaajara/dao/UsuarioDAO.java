package br.com.personalfinancetabaajara.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.personalfinancetabajara.model.Usuario;
import br.com.personalfinancetabajara.util.AppUtil;

public class UsuarioDAO extends BaseDAO {

	private static  UsuarioDAO instancia;
	
	
	
	public static final UsuarioDAO getInstancia(Connection conn) 
	{
		if (instancia == null)
		{
			instancia = new UsuarioDAO(conn);
		}
		return instancia;
	}

	private UsuarioDAO(Connection conn) {
		this.conn = conn;
	}
	

	
	// Insert No banco
	public void Salvar(Usuario user) throws SQLException, NoSuchAlgorithmException {
		// Montando o comando
		String comandoSQL = "insert into usuario (ID_USER, USUARIO, EMAIL, SENHA, NOME)" + " values (?, ?, ?, ?, ?)";
		// Transporte para bd
		PreparedStatement comando = conn.prepareStatement(comandoSQL);
		// Prencher os valores
		comando.setLong(1, nextid(conn,"usuario","id_user"));
		comando.setString(2, user.getUsuario());
		comando.setString(3, user.getEmail());
		comando.setString(4, AppUtil.generateMD5(user.getSenha()));
		comando.setString(5, user.getNome());
		// Executar o comando
		comando.executeUpdate();

	}

	// Login
	public Usuario login(String usuario, String password) throws SQLException, NoSuchAlgorithmException {
		Usuario user = null;
		// Comando SQL
		String comandoSQL = "select id_user, email, senha, nome from usuario where upper(usuario) = ?";
		// Transporte para bd
		PreparedStatement comando = conn.prepareStatement(comandoSQL);
		//
		comando.setString(1, usuario.toUpperCase());
		// Executar busca
		ResultSet resultado = comando.executeQuery();
		if (resultado.next()) {
			String criptografada = AppUtil.generateMD5(password);
			String criptografadabd = resultado.getString("senha");

			if (criptografada.equals(criptografadabd)) {
				user = new Usuario(resultado.getLong("id_user"), usuario, resultado.getString("email"), criptografada,
						resultado.getString("nome"));
			}

		}


		return user;

	}

	// Update info
	public void Update(Usuario user) throws SQLException, NoSuchAlgorithmException {
		// Comando SQL
		String comandoSQL = "update usuario set email = ?, senha = ? where id_user = ?";
		// Transporte bd
		PreparedStatement comando = conn.prepareStatement(comandoSQL);
		// set novos valores
		comando.setString(1, user.getEmail());
		comando.setString(2,AppUtil.generateMD5(user.getSenha()));
		comando.setLong(3, user.getId());
		// executar o comando
		comando.executeUpdate();
		//

	}


}
