package org.grupin.GUI;

import javafx.fxml.FXML;
import org.grupin.main.Main;

public class GerenteGUIController {

    public GerenteGUIController() {
    }

    @FXML
    private void clicado() {
        System.out.println("Printado");
    }

    @FXML
    private void listagemProdutos() {

        try {
            Main.novaJanela("./produtos/listaCompletaProduto.fxml", "Produtos");
        } catch (Exception e ) {
            e.printStackTrace();
        }

    }

    @FXML
    private void listagemVendas() {

        try {
            //System.out.println("Ainda nao");
            Main.novaJanela("./vendas/listaCompletaVendas.fxml", "Vendas");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void listagemAgendamentos() {
        try {
            Main.novaJanela("./agendamentos/listaCompletaAgendamento.fxml", "Agenda");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void listarTodosServicos() {
        try {
            Main.novaJanela("./servicos/listaCompletaServicos.fxml", "Servicos");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void novoProduto() {
        try {
            Main.novaJanela("./produtos/novoProduto.fxml", "Novo Produto");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void removerProduto() {
        try {
            Main.novaJanela("./produtos/buscaProduto.fxml", "Remover Produto");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void novaVenda() {
        try {
            Main.novaJanela("./vendas/criarVenda.fxml", "Nova Venda");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void novaAgendamento() {
        try {
            Main.novaJanela("./agendamentos/novoAgendamento.fxml", "Novo Agendamento");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mudarTagAgendamento() {
        try {
            Main.novaJanela("./agendamentos/buscaAgendamento.fxml", "Mudar estado");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void rmServico() {
        try {
            Main.novaJanela("./servicos/buscaServico.fxml", "Remover Servico");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void novoServico() {
        try {
            Main.novaJanela("./servicos/novoServico.fxml", "Novo Servico");
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sair() {
        System.exit(0);
    }

}
