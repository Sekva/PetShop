package org.grupin.GUI.agendamentos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.main.Main;
import org.grupin.servicos.hallDeEntrada;

public class MudarTagAgendamento {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNovoEstado;


    private hallDeEntrada fachada;
    public MudarTagAgendamento() {
        this.fachada = new hallDeEntrada();
    }

    @FXML
    private void mudarTag(){
        String id = txtId.getText();
        String novoEstado = txtNovoEstado.getText();

        int nId = 0;

        try {
            nId = Integer.parseInt(id);
        } catch (Exception excep) {
            Main.novaJanela("problemaReferenciaInvalida.fxml", "");
        }


        try {
            this.fachada.mudarStatusAgendamento(nId, novoEstado);


            Stage palco = (Stage) this.txtId.getScene().getWindow();
            palco.close();
        } catch (Exception excep) {
            //IGNORE System.out.println("Eita");
        }




    }


}
