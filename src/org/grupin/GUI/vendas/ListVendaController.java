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

    private ObservableList<Venda> masterData = FXCollections.observableArrayList();
    private ObservableList<Venda> filteredData = FXCollections.observableArrayList();

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public ListVendaController() {

        hallDeEntrada fachada = new hallDeEntrada();


        try {
            ArrayList<Venda> lista = fachada.listarVendas();

            for (Venda v : lista) {
                masterData.add(v);
            }

        } catch (Exception excep) {
            //IGNORE System.out.println("Eita");
            excep.printStackTrace();
        }
        // Initially add all data to filtered data
        filteredData.addAll(masterData);

        // Listen for changes in master data.
        // Whenever the master data changes we must also update the filtered data.
        masterData.addListener(new ListChangeListener<Venda>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Venda> change) {
                updateFilteredData();
            }
        });
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table
        nomeClienteCol.setCellValueFactory(
                new PropertyValueFactory<Venda, String>("nomeCliente"));
        numVenda.setCellValueFactory(
                new PropertyValueFactory<Venda, Integer>("numVenda"));
        nomeProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Venda, String>("nomeProduto"));
        valor.setCellValueFactory(
                new PropertyValueFactory<Venda, Double>("valorProduto"));

        // Add filtered data to the table
        tabelaVendas.setItems(filteredData);

        // Listen for text changes in the filter text field
        filtroTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                updateFilteredData();
            }
        });
    }

    /**
     * Updates the filteredData to contain all data from the masterData that
     * matches the current filter.
     */
    private void updateFilteredData() {
        filteredData.clear();

        for (Venda v : masterData) {
            if (matchesFilter(v)) {
                filteredData.add(v);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }


    private boolean matchesFilter(Venda venda) {
        String filterString = filtroTxt.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (venda.getCliente().getNomeCliente().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (Integer.toString(venda.getNumVenda()).toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if(venda.getNomeProduto().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        }

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Venda, ?>> sortOrder = new ArrayList<>(tabelaVendas.getSortOrder());
        tabelaVendas.getSortOrder().clear();
        tabelaVendas.getSortOrder().addAll(sortOrder);
    }



}
