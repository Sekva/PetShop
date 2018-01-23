package org.grupin.GUI.produtos;

import java.util.ArrayList;

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

    private ObservableList<Produto> masterData = FXCollections.observableArrayList();
    private ObservableList<Produto> filteredData = FXCollections.observableArrayList();

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public ListProdutoController() {

        hallDeEntrada fachada = new hallDeEntrada();


        try {
            ArrayList<Produto> lista = fachada.listarProdutos();

            for (Produto p : lista) {
                masterData.add(p);
            }

        } catch (Exception e) {
        System.out.println("Eita");
            e.printStackTrace();
        }
        // Initially add all data to filtered data
        filteredData.addAll(masterData);

        // Listen for changes in master data.
        // Whenever the master data changes we must also update the filtered data.
        masterData.addListener(new ListChangeListener<Produto>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Produto> change) {
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
        nomeProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Produto, String>("nomeProduto"));
        referenciaProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Produto, String>("referenciaProduto"));
        qtdProdutoCol.setCellValueFactory(
                new PropertyValueFactory<Produto, Integer>("quantidadeProduto"));
        valor.setCellValueFactory(
                new PropertyValueFactory<Produto, Double>("valorProdutoVenda"));

        // Add filtered data to the table
        tabelaProduto.setItems(filteredData);

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

        for (Produto p : masterData) {
            if (matchesFilter(p)) {
                filteredData.add(p);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }

    /**
     * Returns true if the person matches the current filter. Lower/Upper case
     * is ignored.
     *
     * @param person
     * @return
     */
    private boolean matchesFilter(Produto person) {
        String filterString = filtroTxt.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (person.getNomeProduto().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getReferenciaProduto().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        }

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Produto, ?>> sortOrder = new ArrayList<>(tabelaProduto.getSortOrder());
        tabelaProduto.getSortOrder().clear();
        tabelaProduto.getSortOrder().addAll(sortOrder);
    }
}