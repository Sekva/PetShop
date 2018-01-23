package org.grupin.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProblemaController {

    @FXML
    private Button BT;

    @FXML
    private void fechar() {
        Stage palco = (Stage) this.BT.getScene().getWindow();
        palco.close();
    }
}
