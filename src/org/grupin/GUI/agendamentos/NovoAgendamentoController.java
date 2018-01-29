package org.grupin.GUI.agendamentos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.entidades.Agendamento;
import org.grupin.entidades.Animal;
import org.grupin.entidades.Cliente;
import org.grupin.entidades.Servico;
import org.grupin.main.Main;
import org.grupin.servicos.HallDeEntrada;

public class NovoAgendamentoController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtDataMarcada;

    @FXML
    private TextField txtNomeAnimal;

    @FXML
    private TextField txtTipoAnimal;

    @FXML
    private TextField txtRacaAnimal;

    @FXML
    private TextField txtRefServico;

    private HallDeEntrada fachada;

    public NovoAgendamentoController(){
        this.fachada = new HallDeEntrada();
    }

    @FXML
    public void registrar() {

        String nomeCliente = this.txtNome.getText();
        String cpf = this.txtCpf.getText();
        String telefone = this.txtTel.getText();
        String dataMarcada = this.txtDataMarcada.getText();
        String nomeAnimal = this.txtNomeAnimal.getText();
        String tipoAnimal = this.txtTipoAnimal.getText();
        String racaAnimal = this.txtRacaAnimal.getText();
        String refServico = this.txtRefServico.getText();



        try {

            if(this.fachada.validarAnimal(nomeAnimal, tipoAnimal, racaAnimal)) {
                Animal a = this.fachada.criarAnimal(nomeAnimal, tipoAnimal, racaAnimal);

                if(this.fachada.validarCliente(nomeCliente, telefone, cpf, a)) {

                    Cliente c = this.fachada.criarCliente(nomeCliente, telefone, cpf, a);

                    Servico s = this.fachada.pegarServico(refServico);

                    if(s != null) {
                        Agendamento ag = this.fachada.criarAgendamento(c, dataMarcada, s);

                        this.fachada.registrarAgendamento(ag);

                        Stage palco = (Stage) this.txtCpf.getScene().getWindow();
                        palco.close();

                    } else {
                        //IGNORE System.out.println("ORRA");

                    }

                } else {
                    //IGNORE System.out.println("Nop");
                    //Login.novaJanela("");
                }

            } else {

            }

        } catch (Exception excep) {
            Main.novaJanela("problemaReferenciaInvalida.fxml", "");
        }




    }



}
