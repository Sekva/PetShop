package org.grupin.GUI.produtos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.entidades.Produto;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.ProdutoNaoEncontradoException;
import org.grupin.exceptions.ReferenciaInvalidaException;
import org.grupin.main.Main;
import org.grupin.servicos.hallDeEntrada;

public class NovoProdutoController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtRef;

    @FXML
    private TextField txtValorVenda;

    @FXML
    private TextField txtValorCompra;

    @FXML
    private TextField txtQuantidade;

    private hallDeEntrada fachada;

    public NovoProdutoController() {this.fachada = new hallDeEntrada();}

    @FXML
    private void registrar() {

        String nomeProduto = txtNome.getText();
        String refProduto = txtRef.getText();

        double valorVenda;
        double valorCompra;
        int quantidade;

        if(verificarLetras(txtValorVenda.getText()) || txtValorVenda.getText().equals("")) {
             valorVenda = 0;
        } else {
            valorVenda = Double.parseDouble(txtValorVenda.getText());
        }

        if(txtValorCompra.getText().equals("") || verificarLetras(txtValorCompra.getText())) {
            valorCompra = 0;
        } else {
            valorCompra = Double.parseDouble(txtValorCompra.getText());
        }

        if (txtQuantidade.getText().equals("") || verificarLetras(txtQuantidade.getText())) {
            quantidade = 0;
        } else {
            quantidade = Integer.parseInt(txtQuantidade.getText());
        }


        if(this.fachada.validarProduto(nomeProduto, refProduto,valorVenda, valorCompra, quantidade)) {

            System.out.println("ok");

            Produto p = this.fachada.criarProduto(nomeProduto, refProduto, valorCompra, valorVenda, "algo", quantidade);

                try {

                    if(this.fachada.pegarProduto(refProduto) != null) {
                        System.out.println("Referencia invalida");
                        Main.novaJanela("problemaReferenciaInvalida.fxml", "");
                    } else {

                        this.fachada.registrarProduto(p);

                        //FECHAR JANELA
                        Stage palco = (Stage) this.txtQuantidade.getScene().getWindow();
                        palco.close();
                    }

                } catch (ArquivoNaoEscitoException e) {
                    Main.novaJanela("problemaBaseDeDados.fxml", "");
                    System.out.println("Arquivo não pode ser escrito");
                    e.printStackTrace();
                }




        } else {
            System.out.println("n ok");
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
