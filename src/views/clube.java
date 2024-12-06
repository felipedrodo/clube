package views;

import models.Clube;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
 
public class clube extends JFrame {
    private JLabel labelRec, labelGasto, labelBil, labelPres, labelTec, labelPos, labelSerie;
    private JTextField tFReceita, tFGasto, tFBilheteria, tFPresidente, tFTecnico ;
    private JComboBox JComboBoxPosicao;
    private JRadioButton radio1, radio2, radio3, radio4;
    private JButton btAdd, btCancel;
    private JPanel jPanel1, jPanel2, jPanel3,radioPanel;
    private Clube clube;
    private boolean isEditMode; 
 
    public clube() {
        super("Dados Clube");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        labelRec = new JLabel("Receita: ");
        tFReceita = new JTextField(5);
        
        labelGasto = new JLabel("Gastos: ");
        tFGasto = new JTextField(5);
        
        labelBil = new JLabel("Bilheteria: ");
        tFBilheteria = new JTextField(5);

        labelPres = new JLabel("Presidente: ");
        tFPresidente = new JTextField(5);

        labelTec = new JLabel("Técnico: ");
        tFTecnico = new JTextField(5);

        radioPanel = new JPanel();
        
        labelSerie = new JLabel("Serie: ");
        radio1 = new JRadioButton ("A", false);
        radio2 = new JRadioButton ("B", false);
        radio3 = new JRadioButton ("C", false);
        radio4 = new JRadioButton ("D", false);

        radioPanel.add(radio1);
        radioPanel.add(radio2);
        radioPanel.add(radio3);
        radioPanel.add(radio4);
        
        labelPos = new JLabel("Posição: ");
        JComboBoxPosicao = new JComboBox();
        JComboBoxPosicao.addItem ("1º");
        JComboBoxPosicao.addItem ("2º");
        JComboBoxPosicao.addItem ("3º");
        JComboBoxPosicao.addItem ("4º");
        JComboBoxPosicao.addItem ("5º");
        JComboBoxPosicao.addItem ("6º");
        JComboBoxPosicao.addItem ("7º");
        JComboBoxPosicao.addItem ("8º");
        JComboBoxPosicao.addItem ("9º");
        JComboBoxPosicao.addItem ("10º");
        JComboBoxPosicao.addItem ("11º");
        JComboBoxPosicao.addItem ("12º");
        JComboBoxPosicao.addItem ("13º");
        JComboBoxPosicao.addItem ("14º");
        JComboBoxPosicao.addItem ("15º");
        JComboBoxPosicao.addItem ("16º");
        JComboBoxPosicao.addItem ("17º");
        JComboBoxPosicao.addItem ("18º");
        JComboBoxPosicao.addItem ("19º");
        JComboBoxPosicao.addItem ("20º");
        
        btAdd = new JButton("Adicionar");
        
        btCancel = new JButton("Cancelar");
 
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
 
        Container janela;
        janela = getContentPane();
        janela.setLayout(new BorderLayout());
 
        jPanel1.setLayout(new GridLayout(7, 1));
        jPanel2.setLayout(new GridLayout(7, 1));
        jPanel3.setLayout(new FlowLayout());
 
        jPanel1.add(labelRec);
        jPanel1.add(labelGasto);
        jPanel1.add(labelBil);
        jPanel1.add(labelPres);
        jPanel1.add(labelTec);
        jPanel1.add(labelSerie);
        jPanel1.add(labelPos);
 
        jPanel2.add(tFReceita);
        jPanel2.add(tFGasto);
        jPanel2.add(tFBilheteria);
        jPanel2.add(tFPresidente);
        jPanel2.add(tFTecnico);
        jPanel2.add(radioPanel);
        jPanel2.add(JComboBoxPosicao);
 
        jPanel3.add(btAdd);
        jPanel3.add(btCancel);
 
        janela.add(jPanel1, BorderLayout.WEST);
        janela.add(jPanel2, BorderLayout.EAST);
        janela.add(jPanel3, BorderLayout.SOUTH);
        setSize(800, 600);
        pack();

		btAdd.addActionListener(new ActionListener() {
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

		btCancel.addActionListener(e -> dispose());

		this.add(jPanel3);
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
            JComboBoxPosicao.getSelectedItem().toString()
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

 
    public static void main(String[] args) {
        clube exBorderLayout = new clube();
        exBorderLayout.setVisible(true);
    }
}