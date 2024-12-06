package controllers;

import models.Clube;
import repository.ClubeRepository;
import views.ClubeForm;
import views.ClubeTableView;
import views.clube;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClubeController {
    private ClubeRepository repository;
    private ClubeTableView tableView;

    public ClubeController() {
        repository = new ClubeRepository();
        tableView = new ClubeTableView();
        inicializar();
    }
    private void inicializar() {
        //Atualizar a tabela com os Clubes existentes
        atualizarTabela();

        //Criar a barra de ferramenta (toolbar) com botões
        JToolBar toolBar = new JToolBar();
        JButton adicionarButton = new JButton("Adicionar");
        JButton editarButton = new JButton("Editar");
        JButton deletarButton = new JButton("Deletar");
        toolBar.add(adicionarButton);
        toolBar.add(editarButton);
        toolBar.add(deletarButton);
        
        tableView.add(toolBar, java.awt.BorderLayout.NORTH);

        // Ações dos botões
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarClube();
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarClube();
            }
        });
        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarClube();
            }
        });
        tableView.setVisible(true);
    }
private void atualizarTabela() {
        List<Clube> Clube = repository.obterTodosClubes();
        tableView.atualizarTabela(Clube);
    }
    
    private void adicionarClube() {
        ClubeForm form = new ClubeForm(tableView, "Adicionar Clube");
        form.setVisible(true);
        Clube novoClube = form.getClube();
        if (novoClube != null) {
            repository.adicionarClube(novoClube);
            atualizarTabela();
        }
    }
private void editarClube() {
        int selectedId = tableView.getSelectedClubeId();
        if (selectedId != -1) {
            Clube Clube = repository.obterClubePorId(selectedId);
            if (Clube != null) {
                ClubeForm form = new ClubeForm(tableView,
                    "Editar Clube", Clube);
                form.setVisible(true);
                Clube ClubeAtualizado = form.getClube();
                if (ClubeAtualizado != null) {
                    ClubeAtualizado = new Clube(
                        selectedId,
                        ClubeAtualizado.getReceita(),
                        ClubeAtualizado.getGastos(),
                        ClubeAtualizado.getBilheteria(),
                        ClubeAtualizado.getSerie(),
                        ClubeAtualizado.getPosicao(),
                        ClubeAtualizado.getPresidente(),
                        ClubeAtualizado.getTecnico()

                    );
                    repository.AtualizarClube(ClubeAtualizado);
                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(tableView,
                    "Clube não encontrado.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(tableView,
                "Selecione um Clube para editar.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
private void deletarClube() {
    int selectedId = tableView.getSelectedClubeId();
    if (selectedId != -1) {
        int confirm = JOptionPane.showConfirmDialog(
            tableView,
            "Tem certeza que deseja deletar esse Clube?",
            "Confirmar Deleção",
            JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            repository.deletarClube(selectedId);
            atualizarTabela();
        }
    } else {
        JOptionPane.showMessageDialog(
            tableView,
            "Selecione um Clube para deletar.",
            "Aviso",
            JOptionPane.WARNING_MESSAGE);
    
        }
    }
    
    public void iniciar() {
        //Ações já são inicializadas no construtor
    }
}