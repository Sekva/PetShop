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
import org.grupin.servicos.hallDeEntrada;

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

    private ObservableList<Servico> masterData = FXCollections.observableArrayList();
    private ObservableList<Servico> filteredData = FXCollections.observableArrayList();

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public ListCompletaServico() {

        hallDeEntrada fachada = new hallDeEntrada();


        try {
            ArrayList<Servico> lista = fachada.listarServicos();

            for (Servico p : lista) {
                masterData.add(p);
            }

        } catch (Exception excep) {
            //IGNORE System.out.println("Eita");
            excep.printStackTrace();
        }
        // Initially add all data to filtered data
        filteredData.addAll(masterData);

        // Listen for changes in master data.
        // Whenever the master data changes we must also update the filtered data.
        masterData.addListener(new ListChangeListener<Servico>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Servico> change) {
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
        nomeServicoCol.setCellValueFactory(
                new PropertyValueFactory<Servico, String>("nomeProduto"));
        referenciaServicoCol.setCellValueFactory(
                new PropertyValueFactory<Servico, String>("referenciaProduto"));
        valor.setCellValueFactory(
                new PropertyValueFactory<Servico, Double>("valorProdutoVenda"));
        categoria.setCellValueFactory(
                new PropertyValueFactory<Servico, String>("categoriaProduto"));

        // Add filtered data to the table
        tabelaServicos.setItems(filteredData);

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

        for (Servico p : masterData) {
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
    private boolean matchesFilter(Servico person) {
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
        } else if(person.getCategoriaProduto().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        }

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Servico, ?>> sortOrder = new ArrayList<>(tabelaServicos.getSortOrder());
        tabelaServicos.getSortOrder().clear();
        tabelaServicos.getSortOrder().addAll(sortOrder);
    }

}
