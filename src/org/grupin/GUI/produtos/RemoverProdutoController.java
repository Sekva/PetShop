package org.grupin.GUI.produtos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.ProdutoNaoEncontradoException;
import org.grupin.main.Main;
import org.grupin.servicos.hallDeEntrada;

public class RemoverProdutoController {

    @FXML
    private Button btOk;

    @FXML
    private TextField txtReferenciaProduto;

    @FXML
    private TextField txtQuantidadeProduto;

    private hallDeEntrada fachada;

    public RemoverProdutoController(){}

    @FXML
    private void buscarProduto() {

        fachada = new hallDeEntrada();
        String referencia = txtReferenciaProduto.getText();






        if(referencia.equals("") || verificarLetras(txtQuantidadeProduto.getText())) {
            //IGNORE System.out.println("String vazia");
            Main.novaJanela("problemaQuantidadeInvalida.fxml", "");

        } else {

            hallDeEntrada fachada = new hallDeEntrada();


            int qtd = Integer.parseInt(txtQuantidadeProduto.getText());
            while (qtd > 0) {
                try {
                    this.fachada.removerProduto(referencia);
                } catch (ProdutoNaoEncontradoException excep) {
                    Main.novaJanela("problemaQuantidadeInvalida.fxml", "");
                } catch (ArquivoNaoEscitoException excep) {
                    Main.novaJanela("problemaBaseDeDados.fxml", "");
                }

                qtd--;
            }



            Stage palco = (Stage) this.txtReferenciaProduto.getScene().getWindow();
            palco.close();
        }

        Stage palco = (Stage) this.txtReferenciaProduto.getScene().getWindow();
        palco.close();


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
