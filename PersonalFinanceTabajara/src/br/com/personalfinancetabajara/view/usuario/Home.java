package br.com.personalfinancetabajara.view.usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.personalfinancetabajara.jdbc.Conexao;

public class Home {

	public static void main(String[] args) throws SQLException, IOException {
		
		
		
		//Variavel
		int opcao;
		
		Scanner in = new Scanner(System.in);
		Connection conn =Conexao.getConn(); 
		
		
		while (true)
		{
		
			//Menu Inicial
			System.out.println();
			System.out.println(" 1  - LOGAR ");
			System.out.println(" 2  - NOVO USUARIO ");
			System.out.println(" 99 - SAIR");
			System.out.println();
			
			
			

			opcao = in.nextInt();
			
			
			//Sair
			if (opcao == 99)
			{
				
				testeascii.textimg("8===D");
				break;	
				
			}
			//
			else if (opcao == 1)
			{
				
				TelaDeLogin.processar(in, conn);
				
			}
			else if (opcao == 2)
			{
				NovoUsuario.processar(in, conn);
				
			}
			else 
			{
				System.out.println(" OPCAO INVALIDA ");
				break;
			}
			
			
			
			
			
		}
		
		
		in.close();
		//Disconnect
		Conexao.disconnect();
		
		
		
	}
	
	
}
