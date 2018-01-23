package org.grupin.GUI.servicos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.main.Main;
import org.grupin.servicos.hallDeEntrada;

public class RemoverServicoController {

    @FXML
    private TextField txtReferenciaServico;

    private hallDeEntrada fachada;

    public RemoverServicoController() {
        this.fachada = new hallDeEntrada();
    }

    @FXML
    private void rmServico() {
        String referencia = this.txtReferenciaServico.getText();

        try {
            this.fachada.removerServico(referencia);

            Stage palco = (Stage) this.txtReferenciaServico.getScene().getWindow();
            palco.close();

        } catch (Exception e) {
            Main.novaJanela("problemaReferenciaInvalida.fxml", "");
        }


    }



}
