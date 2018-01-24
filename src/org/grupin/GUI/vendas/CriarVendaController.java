package org.grupin.GUI.vendas;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.entidades.Animal;
import org.grupin.entidades.Cliente;
import org.grupin.entidades.Produto;
import org.grupin.entidades.Venda;
import org.grupin.main.Main;
import org.grupin.servicos.hallDeEntrada;

import java.util.Random;


public class CriarVendaController {


    @FXML
    private TextField txtCPF;

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
    private TextField txtRefProduto;

    private hallDeEntrada fachada;

    public CriarVendaController() {
        this.fachada = new hallDeEntrada();
    }

    @FXML
    private void criarVenda() {

        String nomeCliente = this.txtNome.getText();
        String telefone = this.txtTel.getText();
        String cpfR = this.txtCPF.getText();
        String tipoAnimal = this.txtTipoAnimal.getText();
        String racaAnimal = this.txtRacaDoAnimal.getText();
        String nomeAnimal = this.txtNomeAnimal.getText();
        String refProduto = this.txtRefProduto.getText();

        int numVenda = new Random().nextInt();


        if(tipoAnimal.equals("") || racaAnimal.equals("") || nomeAnimal.equals("")) {

            try {
                //IGNORE System.out.println(nomeCliente + " " + telefone + " " + cpfR + "qqq");
                if(this.fachada.pegarProduto(refProduto) != null && this.fachada.validarCliente(nomeCliente, telefone, cpfR)) {

                    //IGNORE System.out.println("aqui2");
                    Produto p = this.fachada.pegarProduto(refProduto);
                    Cliente c = this.fachada.criarCliente(nomeCliente, telefone, cpfR);

                    //IGNORE System.out.println("aqui3");

                    if(this.fachada.validarVenda(p, numVenda, c)) {


                        //IGNORE System.out.println("aqui3");

                        Venda v = this.fachada.criarVenda(p, numVenda, c);

                        try {

                            //IGNORE System.out.println("aqui4");
                            this.fachada.registrarVenda(v);
                            this.fachada.removerProduto(refProduto);
                        } catch (Exception excep) {
                            excep.printStackTrace();
                        }

                    }


                    //IGNORE System.out.println("aqui5");

                } else {
                    Main.novaJanela("problemaReferenciaInvalida.fxml", "");
                }

            } catch (Exception excep) {
                excep.printStackTrace();
            } finally {
                Stage palco = (Stage) this.txtCPF.getScene().getWindow();
                palco.close();
            }

        } else {
            try {

                if(this.fachada.validarAnimal(nomeAnimal, tipoAnimal, racaAnimal)) {

                    Animal a = this.fachada.criarAnimal(nomeAnimal, tipoAnimal, racaAnimal);

                    if(this.fachada.pegarProduto(refProduto) != null && this.fachada.validarCliente(nomeCliente, telefone, cpfR, a)) {

                        Produto p = this.fachada.pegarProduto(refProduto);
                        Cliente c = this.fachada.criarCliente(nomeCliente, telefone, cpfR, a);

                        if(this.fachada.validarVenda(p, numVenda, c)) {

                            Venda v = this.fachada.criarVenda(p, numVenda, c);

                            try {
                                this.fachada.registrarVenda(v);
                                this.fachada.removerProduto(refProduto);
                            } catch (Exception excep) {
                                excep.printStackTrace();
                            }

                        }

                    } else {
                        Main.novaJanela("problemaReferenciaInvalida.fxml", "");
                    }
                }

            } catch (Exception excep) {
                excep.printStackTrace();
                Main.novaJanela("problemasValoresInvalidos.fxml", "");
            } finally {
                Stage palco = (Stage) this.txtCPF.getScene().getWindow();
                palco.close();
            }
        }







    }





}
