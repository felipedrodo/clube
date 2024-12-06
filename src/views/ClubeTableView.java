package views;

import models.Clube;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ClubeTableView extends JFrame {
	private JTable table;
	private DefaultTableModel tableModel;

	public ClubeTableView() {
		super ("Gerenciamento de Clube");
		initializeComponents();
	}

private void initializeComponents() {
		String[] columnNames = {"ID", "Receita", "Gastos", "Bilheteria", "Serie", "Posicao"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBorder(
			BorderFactory.createEmptyBorder(10, 10, 10, 10));

		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);

		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

public void atualizarTabela(List<Clube> clubes) {
		tableModel.setRowCount(0); //limpa a tabela
		for (Clube clube : clubes) {
			Object[] row = {
				clube.getId(),
				clube.getReceita(),
				clube.getGastos(),
				clube.getBilheteria(),
				clube.getSerie(),
				clube.getPosicao(),
				clube.getPresidente(),
				clube.getTecnico()

			};
			tableModel.addRow(row);
		}
	}

public int getSelectedClubeId() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			return (int) tableModel.getValueAt(selectedRow, 0);
		}
		return -1;
	}
}