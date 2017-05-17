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

public class AlterarGastos {

	public static void processar(Scanner in, Connection conn, Long id) {

		int opcao;

		GastosDAO dao = GastosDAO.getInstancia(conn);

		while (true) {
			System.out.println(" 1 - ALTERAR GASTOS ");
			System.out.println(" 2 - VOLTAR ");

			opcao = in.nextInt();

			if (opcao == 2) {
				break;
			}
			if (opcao == 1) {
				System.out.println(" DESCRICAO ");
				String descricao = in.next();
				System.out.println(" VALOR ");
				double valor = 0;
				String vlr = in.next();
				vlr = vlr.replace(',', '.');
				try {
					valor = Double.parseDouble(vlr);
				} catch (Exception e) {
					System.out.println("Valor invalido.");
					continue;
				}
				System.out.println(" DATA ");
				String datastr = in.next();
				Date data;
				try {
					data = AppUtil.strDateToDate(datastr);
					Gastos gastos = new Gastos(descricao, valor, data);
					gastos.setId(id);
					try {
						dao.update(gastos);
						System.out.println(" Alterado com SUCESSO ");
					} catch (NoSuchAlgorithmException | SQLException e) {
						System.out.println(" Ocorreu um erro inesperado ");
						e.printStackTrace();
						continue;
					}
				} catch (ParseException e1) {
					System.out.println(" FORMATO DE DATA ERRADA (dd/MM/yyyy) ");
					continue;
				}

			}

		}

	}
}
