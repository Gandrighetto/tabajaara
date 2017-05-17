package br.com.personalfinancetabajara.view.usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.personalfinancetabajara.model.Usuario;
import br.com.personalfinancetabajara.view.gasto.CadastrarGastos;
import br.com.personalfinancetabajara.view.gasto.VisualizarGastos;

public class HomeUsuario {

	public static void processar(Scanner in,Connection conn,Usuario autenticado) throws IOException{
		System.out.println();
		testeascii.textimg("BEM VINDO  " +  autenticado.getNome().toUpperCase());
		
		int opcao;
		while (true){
			System.out.println(" 1 - VISUALIZAR GASTOS ");
			System.out.println(" 2 - CADASTRAR GASTOS ");
			System.out.println(" 3 - ALTERAR DADOS CADASTRAIS ");
			System.out.println(" 9 - LOGOFF ");
			
			opcao = in.nextInt();
			
			if(opcao == 9){
				testeascii.textimg("ATÉ MAIS  " + autenticado.getNome().toUpperCase());
				break;
			}
			else if(opcao == 1){
				try {
					VisualizarGastos.processar(in, conn);
				} catch (SQLException e) {
					System.out.println(" Ocorreu um erro inesperado ");
					e.printStackTrace();
				}
			}
			else if(opcao == 2){
				CadastrarGastos.processar(in, conn);
			}
			else if(opcao == 3){
				AlterarDados.processar(in, conn, autenticado);
				
			}
			
			
			
		}
		

		
		
		
		
		
	}

}
