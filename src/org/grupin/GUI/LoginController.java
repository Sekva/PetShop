package org.grupin.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.grupin.main.Main;

public class LoginController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private void logar() {
        String login = this.txtLogin.getText();
        String senha = this.txtSenha.getText();

        if(login.equals("admin") && senha.equals("admin")) {

            Main.novaJanela("gerenteGUI.fxml", "PETO SHOPO");
            this.fechar();

        } else if(login.equals("usr") && senha.equals("usr")) {

            Main.novaJanela("vendedorGUI.fxml", "PETO SHOPO");
            this.fechar();

        } else {

            Main.novaJanela("problemaLogin.fxml", "PETO SHOPO");

        }


    }

    private void fechar() {
        Stage palco = (Stage) this.txtLogin.getScene().getWindow();
        palco.close();
    }


}
