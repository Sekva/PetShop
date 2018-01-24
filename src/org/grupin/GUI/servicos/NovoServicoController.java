package org.grupin.GUI.servicos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.entidades.Servico;
import org.grupin.main.Main;
import org.grupin.servicos.hallDeEntrada;

public class NovoServicoController {

    @FXML
    private TextField txtNomeServico;

    @FXML
    private TextField txtRefServico;

    @FXML
    private TextField txtValorCompra;

    @FXML
    private TextField txtValorVenda;

    @FXML
    private TextField txtCategoria;


    private hallDeEntrada fachada;


    public NovoServicoController() {
        this.fachada = new hallDeEntrada();
    }

    @FXML
    public void registrarServico() {
        String nomeServico = this.txtNomeServico.getText();
        String refServico = this.txtRefServico.getText();
        String valorCompra = this.txtValorCompra.getText();
        String valorVenda = this.txtValorVenda.getText();
        String categoria = this.txtCategoria.getText();

        if(nomeServico.equals("") || refServico.equals("") || valorCompra.equals("") || valorVenda.equals("") || categoria.equals("")) {
            Main.novaJanela("problemasValoresInvalidos.fxml", "");
            return;
        }

        double valorC, valorV;

        if(!verificarLetras(valorCompra)) {
            valorC = Double.parseDouble(valorCompra);
        } else {
            Main.novaJanela("problemasValoresInvalidos.fxml", "");
            return;
        }

        if(!verificarLetras(valorVenda)) {
            valorV = Double.parseDouble(valorVenda);
        } else {
            Main.novaJanela("problemasValoresInvalidos.fxml", "");
            return;
        }


        Servico s = this.fachada.criarServico(nomeServico, refServico, valorC, valorV, categoria);

        try {
            this.fachada.registrarServico(s);


            Stage palco = (Stage) this.txtCategoria.getScene().getWindow();
            palco.close();
        } catch (Exception excep) {
            Main.novaJanela("problemaBaseDeDados.fxml", "");
        }








    }


    private boolean verificarLetras(String s) {
        String maiuscula = s.toUpperCase();

        char[] stringArray = maiuscula.toCharArray();


        for (char c : stringArray) {
            if(c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'G' || c == 'H' || c == 'I' || c == 'J' || c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'O' || c == 'P' || c == 'Q' || c == 'R' || c == 'S' || c == 'T' || c == 'U' || c == 'V' || c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
                return true;
            }
        }
        return false;
    }

}
