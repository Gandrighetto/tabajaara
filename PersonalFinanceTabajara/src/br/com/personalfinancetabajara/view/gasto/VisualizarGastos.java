package br.com.personalfinancetabajara.view.gasto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.personalfinancetabaajara.dao.GastosDAO;
import br.com.personalfinancetabajara.model.Gastos;
import br.com.personalfinancetabajara.util.AppUtil;

public class VisualizarGastos {

	public static void processar(Scanner in, Connection conn) throws SQLException {

		GastosDAO dao = GastosDAO.getInstancia(conn);
		while (true) {
			ArrayList<Gastos> list = dao.list();

			for (Gastos gasto : list) {

				String datastr = AppUtil.dateToStr(gasto.getData());

				System.out.println(
						gasto.getId() + " | " + gasto.getDescricao() + " | " + gasto.getValor() + " | " + datastr);

			}
			int opcao;
			System.out.println();
			System.out.println();
			System.out.println(" 1 - para ALTERAR");
			System.out.println(" 2 - para EXCLUIR");
			System.out.println(" 3 - para LISTAR");
			System.out.println(" 4 - para VOLTAR");
			opcao = in.nextInt();

			if (opcao == 3) {

				continue;

			}

			if (opcao == 4) {
				break;
			}
			if (opcao == 1) {
				System.out.println(" Digite o ID do registro que voce quer ALTERAR");
				Long id = in.nextLong();
				AlterarGastos.processar(in, conn, id);
			}
			if (opcao == 2) {
				System.out.println(" Digite o ID do registro a ser EXCLUIDO ");
				Long id = in.nextLong();
				System.out.println(" Tem certeza que deseja EXCLUIR o ID (s/n) " + id);
				String sn = in.next();
				if (sn.equals("s")) {
					dao.remover(id);
					System.out.println(" Deletado com SUCESSO ");

				}
			}

		}

	}

}
