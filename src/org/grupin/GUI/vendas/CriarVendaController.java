package org.grupin.GUI.vendas;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.entidades.*;
import org.grupin.main.Main;
import org.grupin.servicos.hallDeEntrada;

import java.util.Random;


public class CriarVendaController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtTipoAnimal;

    @FXML
    private TextField txtRacaDoAnimal;

    @FXML
    private TextField txtNomeAnimal;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtRefProduto;

    private hallDeEntrada fachada;

    public CriarVendaController() {
        this.fachada = new hallDeEntrada();
    }

    @FXML
    private void criarVenda() {

        String nomeCliente = this.txtNome.getText();
        String telefone = this.txtTel.getText();
        String tipoAnimal = this.txtTipoAnimal.getText();
        String racaAnimal = this.txtRacaDoAnimal.getText();
        String nomeAnimal = this.txtNomeAnimal.getText();
        String cpf = this.txtCPF.getText();
        String refProduto = this.txtRefProduto.getText();

        int numVenda = new Random(10000).nextInt();


        if(tipoAnimal.equals("") || racaAnimal.equals("") || nomeAnimal.equals("")) {

            try {

                if(this.fachada.pegarProduto(refProduto) != null && this.fachada.validarCliente(nomeCliente, telefone, cpf)) {

                    Produto p = this.fachada.pegarProduto(refProduto);
                    Cliente c = this.fachada.criarCliente(nomeCliente, telefone, cpf);

                    if(this.fachada.validarVenda(p, numVenda, c)) {

                        Venda v = this.fachada.criarVenda(p, numVenda, c);

                        try {
                            this.fachada.registrarVenda(v);
                            this.fachada.removerProduto(refProduto);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                } else {
                    Main.novaJanela("problemaReferenciaInvalida.fxml", "");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Stage palco = (Stage) this.txtCPF.getScene().getWindow();
                palco.close();
            }

        } else {
            try {

                if(this.fachada.validarAnimal(nomeAnimal, tipoAnimal, racaAnimal)) {

                    Animal a = this.fachada.criarAnimal(nomeAnimal, tipoAnimal, racaAnimal);

                    if(this.fachada.pegarProduto(refProduto) != null && this.fachada.validarCliente(nomeCliente, telefone, cpf, a)) {

                        Produto p = this.fachada.pegarProduto(refProduto);
                        Cliente c = this.fachada.criarCliente(nomeCliente, telefone, cpf, a);

                        if(this.fachada.validarVenda(p, numVenda, c)) {

                            Venda v = this.fachada.criarVenda(p, numVenda, c);

                            try {
                                this.fachada.registrarVenda(v);
                                this.fachada.removerProduto(refProduto);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                    } else {
                        Main.novaJanela("problemaReferenciaInvalida.fxml", "");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Stage palco = (Stage) this.txtCPF.getScene().getWindow();
                palco.close();
            }
        }







    }





}
