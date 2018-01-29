package org.grupin.GUI.servicos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.grupin.entidades.Servico;
import org.grupin.servicos.HallDeEntrada;

import java.util.ArrayList;

public class ListCompletaServico {


    @FXML
    private TextField filtroTxt;
    @FXML
    private TableView<Servico> tabelaServicos;
    @FXML
    private TableColumn<Servico, String> nomeServicoCol;
    @FXML
    private TableColumn<Servico, String> referenciaServicoCol;
    @FXML
    private TableColumn<Servico, Double> valor;
    @FXML
    private TableColumn<Servico, String> categoria;

    private ObservableList<Servico> listaCompleta = FXCollections.observableArrayList();
    private ObservableList<Servico> listaFiltrada = FXCollections.observableArrayList();



    public ListCompletaServico() {

        HallDeEntrada fachada = new HallDeEntrada();


        try {
            ArrayList<Servico> lista = fachada.listarServicos();

            for (Servico p : lista) {
                listaCompleta.add(p);
            }

        } catch (Exception excep) {

            excep.printStackTrace();
        }

        listaFiltrada.addAll(listaCompleta);


        listaCompleta.addListener(new ListChangeListener<Servico>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Servico> change) {
                attFiltro();
            }
        });
    }



    @FXML
    private void initialize() {

        nomeServicoCol.setCellValueFactory(
                new PropertyValueFactory<Servico, String>("nomeProduto"));
        referenciaServicoCol.setCellValueFactory(
                new PropertyValueFactory<Servico, String>("referenciaProduto"));
        valor.setCellValueFactory(
                new PropertyValueFactory<Servico, Double>("valorProdutoVenda"));
        categoria.setCellValueFactory(
                new PropertyValueFactory<Servico, String>("categoriaProduto"));


        tabelaServicos.setItems(listaFiltrada);


        filtroTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                attFiltro();
            }
        });
    }



    private void attFiltro() {
        listaFiltrada.clear();

        for (Servico p : listaCompleta) {
            if (verificarFiltro(p)) {
                listaFiltrada.add(p);
            }
        }


        reordenar();
    }



    private boolean verificarFiltro(Servico s) {
        String txtFiltro = filtroTxt.getText();
        if (txtFiltro == null || txtFiltro.isEmpty()) {

            return true;
        }

        String strFiltroMin = txtFiltro.toLowerCase();

        if (s.getNomeProduto().toLowerCase().indexOf(strFiltroMin) != -1) {
            return true;
        } else if (s.getReferenciaProduto().toLowerCase().indexOf(strFiltroMin) != -1) {
            return true;
        } else if(s.getCategoriaProduto().toLowerCase().indexOf(strFiltroMin) != -1) {
            return true;
        }

        return false;

    }

    private void reordenar() {
        ArrayList<TableColumn<Servico, ?>> ordem = new ArrayList<>(tabelaServicos.getSortOrder());
        tabelaServicos.getSortOrder().clear();
        tabelaServicos.getSortOrder().addAll(ordem);
    }

}
