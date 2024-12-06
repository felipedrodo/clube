package views;

import models.Clube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClubeForm extends JDialog {
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField telefoneField;
	private JButton salvarButton;
	private JButton cancelarButton;

	private Clube clube;
	private boolean isEditMode;
	
	public ClubeForm(Frame parent, String title) {
		super(parent, title, true);
		this.isEditMode = false;
		initializeComponents();
	}

	public ClubeForm(Frame parent, String title, Clube clube) {
		super(parent, title, true);
		this.clube = clube;
		this.isEditMode = false;
		initializeComponents();
		preencherCampos();
	}

	private void initializeComponents() {
		nomeField = new JTextField(20);
		emailField = new JTextField(20);
		telefoneField = new JTextField(20);
		salvarButton = new JButton("Salvar");
		cancelarButton = new JButton("Cancelar");

		JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
		panel.add(new JLabel("Nome:"));
		panel.add(nomeField);
		panel.add(new JLabel("Email:"));
		panel.add(emailField);
		panel.add(new JLabel("Telefone:"));
		panel.add(telefoneField);
		panel.add(salvarButton);
		panel.add(cancelarButton);


		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarCampos()) {
					if (isEditMode) {
						atualizarClube();
					} else {
						adicionarClube();
					}
					dispose();
				}
			}
		});

		cancelarButton.addActionListener(e -> dispose());

		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(getParent());
	}

	private void preencherCampos() {
        if (clube !=null) {
			tFReceita.setText(String.valueOf(clube.getReceita()));
			tFGasto.setText(String.valueOf(clube.getGastos()));
            tFBilheteria.setText(String.valueOf(clube.getBilheteria()));
            tFPresidente.setText(clube.getPresidente());
            tFTecnico.setText(clube.getTecnico());
            radio1.setEnabled(false);
            radio2.setEnabled(false);
            radio3.setEnabled(false);
            radio4.setEnabled(false);
		}
	}

    private boolean validarCampos() {
		if (tFReceita.getText().trim().isEmpty() ||
				tFGasto.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(
				this,
				"receitas e Gastos são obrigatórios.",
				"Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private void adicionarClube() {
		
        String serie;
        if(radio1.isSelected())
        serie="A";
        if(radio2.isSelected())
        serie="B";
        if(radio3.isSelected())
        serie="C";
        else{
            serie="D";
        }

        String posicao;
        
        clube = new Clube(
			Double.parseDouble(tFReceita.getText()),
			Double.parseDouble(tFGasto.getText()),
            Double.parseDouble(tFBilheteria.getText()),
			tFPresidente.getText().trim(),
            tFTecnico.getText().trim(),
            serie,
            posicao.getSelectedItem().toString()
		);
	}

	private void atualizarClube() {
		if (clube != null) {
			clube.setReceita(Double.parseDouble(tFReceita.getText().trim()));
			clube.setGastos(Double.parseDouble(tFGasto.getText().trim()));
            clube.setBilheteria(Double.parseDouble(tFBilheteria.getText().trim()));
			clube.setPresidente(tFPresidente.getText().trim());
            clube.setTecnico(tFTecnico.getText().trim());
		}
	}
	public Clube getClube() {
		return clube;
	}
}