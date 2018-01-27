package org.grupin.GUI.produtos;

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
import org.grupin.entidades.Produto;
import org.grupin.servicos.hallDeEntrada;

import java.util.ArrayList;

public class ListProdutoController {

    @FXML
    private TextField filtroTxt;
    @FXML
    private TableView<Produto> tabelaProduto;
    @FXML
    private TableColumn<Produto, String> nomeProdutoCol;
    @FXML
    private TableColumn<Produto, String> referenciaProdutoCol;
    @FXML
    private TableColumn<Produto, Integer> qtdProdutoCol;
    @FXML
    private TableColumn<Produto, Double> valor;

    private ObservableList<Produto> listaCompleta = FXCollections.observableArrayList();
    private ObservableList<Produto> listaFiltrada = FXCollections.observableArrayList();



    public ListProdutoController() {

        hallDeEntrada fachada = new hallDeEntrada();


        try {
            ArrayList<Produto> lista = fachada.listarProdutos();

            for (Produto p : lista) {
                listaCompleta.add(p);
            }

        } catch (Exception excep) {

            excep.printStackTrace();
        }

        listaFiltrada.addAll(listaCompleta);



        listaCompleta.addListener(new ListChangeListener<Produto>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Produto> change) {
                attFiltro();
            }
        });
    }



    @FXML
    private void initialize() {

        nomeProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Produto, String>("nomeProduto"));
        referenciaProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Produto, String>("referenciaProduto"));
        qtdProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Produto, Integer>("quantidadeProduto"));
        valor.setCellValueFactory(
                new PropertyValueFactory<Produto, Double>("valorProdutoVenda"));


        tabelaProduto.setItems(listaFiltrada);


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

        for (Produto p : listaCompleta) {
            if (verficarFiltro(p)) {
                listaFiltrada.add(p);
            }
        }


        reordenar();
    }




    private boolean verficarFiltro(Produto p) {
        String filtroString = filtroTxt.getText();
        if (filtroString == null || filtroString.isEmpty()) {

            return true;
        }

        String stingMin = filtroString.toLowerCase();

        if (p.getNomeProduto().toLowerCase().indexOf(stingMin) != -1) {
            return true;
        } else if (p.getReferenciaProduto().toLowerCase().indexOf(stingMin) != -1) {
            return true;
        }

        return false;

    }

    private void reordenar() {
        ArrayList<TableColumn<Produto, ?>> ordem = new ArrayList<>(tabelaProduto.getSortOrder());
        tabelaProduto.getSortOrder().clear();
        tabelaProduto.getSortOrder().addAll(ordem);
    }
}