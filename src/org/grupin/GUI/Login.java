package org.grupin.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("PETO SHOPO");

        try {

            FXMLLoader cargador = new FXMLLoader(Login.class.getResource("gerenteGUI.fxml"));
            Pane pane = cargador.load();
            Scene cena = new Scene(pane);
            primaryStage.setScene(cena);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }

    }


    public static void novaJanela(String janela) {

        try {
            Stage novo = new Stage();
            FXMLLoader loader = new FXMLLoader(Login.class.getResource(janela));
            Pane pane = loader.load();
            Scene cena = new Scene(pane);
            novo.setScene(cena);
            novo.setResizable(false);
            novo.show();

        } catch (Exception excep) {
            excep.printStackTrace();
        }


    }
}
