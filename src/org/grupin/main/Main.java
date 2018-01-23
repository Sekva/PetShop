package org.grupin.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PETO SHOPO");

        try {

            FXMLLoader cargador = new FXMLLoader(Main.class.getResource("../GUI/gerenteGUI.fxml"));
            Pane pane = cargador.load();
            Scene cena = new Scene(pane);
            primaryStage.setScene(cena);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {launch(args);}

    public static void novaJanela(String janela, String titulo) {

        try {
            Stage novo = new Stage();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../GUI/" + janela));
            Pane pane = loader.load();
            Scene cena = new Scene(pane);
            novo.setScene(cena);
            novo.setResizable(false);
            novo.setTitle(titulo);
            novo.show();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
