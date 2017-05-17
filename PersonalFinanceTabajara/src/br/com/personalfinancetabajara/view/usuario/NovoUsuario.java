package br.com.personalfinancetabajara.view.usuario;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.personalfinancetabaajara.dao.UsuarioDAO;
import br.com.personalfinancetabajara.model.Usuario;

public class NovoUsuario {

	public static void processar(Scanner in, Connection conn) 
	{
		
		
		UsuarioDAO dao = UsuarioDAO.getInstancia(conn);
		while (true)
		{
			
			System.out.println(" Digite o seu nome de USUARIO ");
			String usuario = in.next();
			System.out.println(" Digite seu E-MAIL ");
			String email = in.next();
			System.out.println(" Digite sua SENHA ");
			String password = in.next();
			System.out.println(" Re-digite sua SENHA ");
			String repassword = in.next();
			if (!password.equals(repassword))
			{
				System.out.println(" SENHA DIFERENTE ");
				continue;
			}
			System.out.println(" Digite seu NOME ");
			String nome = in.next();
			
			
			Usuario user = new Usuario(usuario,email,password,nome);
			try {
				dao.Salvar(user);
				System.out.println(" USUARIO CRIADO COM SUCESSO! ");
				break;
			
			} catch (NoSuchAlgorithmException | SQLException e) {
				System.out.println(" Ocorreu um erro inesperado! ");
				e.printStackTrace();
			}
			
			
			
			
		}
		
		

	}

}
