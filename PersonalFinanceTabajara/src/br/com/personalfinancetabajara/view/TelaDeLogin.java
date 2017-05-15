package br.com.personalfinancetabajara.view;

import java.sql.Connection;
import java.util.Scanner;

import br.com.personalfinancetabaajara.dao.UsuarioDAO;
import br.com.personalfinancetabajara.model.Usuario;

public class TelaDeLogin {

	public static void processar(Scanner in, Connection conn)
	{
	
		int opcao;
		
		UsuarioDAO dao = UsuarioDAO.getInstancia(conn);
		while (true)
		{
		
			System.out.println(" 1 - FAZER LOGIN ");
			System.out.println(" 2 - VOLTAR ");
			opcao = in.nextInt();
			
			if(opcao == 2)
			{
				
				break;
			}
			
			else if (opcao == 1){
				System.out.println();
				System.out.println(" Usuario ");
				String usuario = in.next();
				System.out.println(" Senha ");
				String password = in.next();
				try {
					Usuario user = dao.login(usuario, password);
					if (user == null)
					{
						System.out.println(" Usuario ou senha errada ");
					}
					else 
					{
						System.out.println(" Autenticado com Sucesso! ");
						HomeUsuario.processar(in, conn, user);
						break;
					}
				} catch (Exception e) {
					System.out.println(" Ocorreu um erro inesperado ");
					e.printStackTrace();
				}
				
			}
			else
			{
				System.out.println(" OPCAO INVALIDA ");
			}
		
	}
		
		
	}

}
