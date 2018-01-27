package org.grupin.GUI.vendas;

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
import org.grupin.entidades.Venda;
import org.grupin.servicos.hallDeEntrada;

import java.util.ArrayList;

public class ListVendaController {

    @FXML
    private TextField filtroTxt;
    @FXML
    private TableView<Venda> tabelaVendas;
    @FXML
    private TableColumn<Venda, String> nomeClienteCol;
    @FXML
    private TableColumn<Venda, Integer> numVenda;
    @FXML
    private TableColumn<Venda, String> nomeProdutoCol;
    @FXML
    private TableColumn<Venda, Double> valor;

    private ObservableList<Venda> listaCompleta = FXCollections.observableArrayList();
    private ObservableList<Venda> listaFiltrada = FXCollections.observableArrayList();



    public ListVendaController() {

        hallDeEntrada fachada = new hallDeEntrada();


        try {
            ArrayList<Venda> lista = fachada.listarVendas();

            for (Venda v : lista) {
                listaCompleta.add(v);
            }

        } catch (Exception excep) {

            excep.printStackTrace();
        }

        listaFiltrada.addAll(listaCompleta);



        listaCompleta.addListener(new ListChangeListener<Venda>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Venda> change) {
                attFiltro();
            }
        });
    }



    @FXML
    private void initialize() {

        nomeClienteCol.setCellValueFactory(
                new PropertyValueFactory<Venda, String>("nomeCliente"));
        numVenda.setCellValueFactory(
                new PropertyValueFactory<Venda, Integer>("numVenda"));
        nomeProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Venda, String>("nomeProduto"));
        valor.setCellValueFactory(
                new PropertyValueFactory<Venda, Double>("valorProduto"));


        tabelaVendas.setItems(listaFiltrada);


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

        for (Venda v : listaCompleta) {
            if (verificarFiltro(v)) {
                listaFiltrada.add(v);
            }
        }


        reordenar();
    }


    private boolean verificarFiltro(Venda venda) {
        String txtFiltro = filtroTxt.getText();
        if (txtFiltro == null || txtFiltro.isEmpty()) {

            return true;
        }

        String strMin = txtFiltro.toLowerCase();

        if (venda.getCliente().getNomeCliente().toLowerCase().indexOf(strMin) != -1) {
            return true;
        } else if (Integer.toString(venda.getNumVenda()).toLowerCase().indexOf(strMin) != -1) {
            return true;
        } else if(venda.getNomeProduto().toLowerCase().indexOf(strMin) != -1) {
            return true;
        }

        return false;

    }

    private void reordenar() {
        ArrayList<TableColumn<Venda, ?>> ordem = new ArrayList<>(tabelaVendas.getSortOrder());
        tabelaVendas.getSortOrder().clear();
        tabelaVendas.getSortOrder().addAll(ordem);
    }



}
