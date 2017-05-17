package br.com.personalfinancetabajara.view.gasto;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import br.com.personalfinancetabaajara.dao.GastosDAO;
import br.com.personalfinancetabajara.model.Gastos;
import br.com.personalfinancetabajara.util.AppUtil;

public class CadastrarGastos {

		
		
		public static void processar(Scanner in, Connection conn) 
		{
		
			
			GastosDAO dao = GastosDAO.getInstancia(conn);
			while (true)
			{
				
				System.out.println(" Digite a descricao do GASTO ");
				String descricao = in.next();
				System.out.println(" Digite o valor ");
				double valor = 0;
				String vlr = in.next();
				vlr = vlr.replace(',', '.');
				try {
					valor = Double.parseDouble(vlr);
				} catch (Exception e) {
					System.out.println("Valor invalido.");
					continue;
				}
				
				System.out.println(" Digite a DATA  ");
				String datastring = in.next();
				try {
					Date data = AppUtil.strDateToDate(datastring);
					Gastos gasto = new Gastos(descricao, valor, data);
					try {
						dao.salvar(gasto);
						System.out.println(" Salvo com sucesso");
						break;
					
					} catch (NoSuchAlgorithmException | SQLException e) {
						System.out.println(" Ocorreu um erro inesperado! ");
						e.printStackTrace();
						continue;
					}
				} catch (ParseException e1) {
					System.out.println(" Data digitada não esta no padrao dd/MM/yyyy ");
					continue;
				}
			
				
				
				
				
				
			}
			
			

		}
		
		

}
