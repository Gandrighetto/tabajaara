package br.com.personalfinancetabajara.view.usuario;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.personalfinancetabaajara.dao.UsuarioDAO;
import br.com.personalfinancetabajara.model.Usuario;

public class AlterarDados {

	public static void processar(Scanner in,Connection conn,Usuario autenticado) {
		
		int opcao;
		
		
		UsuarioDAO dao = UsuarioDAO.getInstancia(conn);
		
		while(true)
		{
			System.out.println(" 1 - ALTERAR E-MAIL ");
			System.out.println(" 2 - ALTERAR SENHA ");
			System.out.println(" 3 - VOLTAR ");
			
			opcao = in.nextInt();
			
			if(opcao == 3)
			{
				break;
			}
			if(opcao == 1)
			{
				System.out.println(" DIGITE O NOVO E-MAIL ");
				String email = in.next();
				autenticado.setEmail(email);
				try {
					dao.Update(autenticado);
					
				} catch (NoSuchAlgorithmException | SQLException e) {
					System.out.println(" Ocorreu um erro inesperado ");
					e.printStackTrace();
				}
			}
			if(opcao == 2)
			{
				System.out.println(" DIGITE A NOVA SENHA ");
				String password = in.next();
				autenticado.setSenha(password);
				try {
					dao.Update(autenticado);
				} catch (NoSuchAlgorithmException | SQLException e) {
					System.out.println(" Ocorreu um erro inesperado ");
					e.printStackTrace();
				}
			}
			
		}
		
		

	}

}
