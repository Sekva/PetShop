package org.grupin.GUI.agendamentos;

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
import org.grupin.entidades.Agendamento;
import org.grupin.servicos.hallDeEntrada;

import java.util.ArrayList;

public class ListAgendamentosController {
    @FXML
    private TextField filtroTxt;
    @FXML
    private TableView<Agendamento> tabelaProduto;
    @FXML
    private TableColumn<Agendamento, String> nomeClienteCol;
    @FXML
    private TableColumn<Agendamento, String> animalCol;
    @FXML
    private TableColumn<Agendamento, String> dataMarcada;
    @FXML
    private TableColumn<Agendamento, Double> valor;
    @FXML
    private TableColumn<Agendamento, String> estadoCol;
    @FXML
    private TableColumn<Agendamento, Integer> idCol;
    @FXML
    private TableColumn<Agendamento, String> nomeServicoCol;

    private ObservableList<Agendamento> masterData = FXCollections.observableArrayList();
    private ObservableList<Agendamento> filteredData = FXCollections.observableArrayList();

    public ListAgendamentosController() {

        hallDeEntrada fachada = new hallDeEntrada();


        try {
            ArrayList<Agendamento> lista = fachada.listarAgendamentos();

            for (Agendamento p : lista) {
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
        masterData.addListener(new ListChangeListener<Agendamento>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Agendamento> change) {
                updateFilteredData();
            }
        });
    }

    @FXML
    private void initialize() {
        // Initialize the person table
        nomeClienteCol.setCellValueFactory(
                new PropertyValueFactory<Agendamento, String>("nomeCliente"));
        animalCol.setCellValueFactory(
                new PropertyValueFactory<Agendamento, String>("nomeAnimal"));
        dataMarcada.setCellValueFactory(
                new PropertyValueFactory<Agendamento, String>("dataMarcada"));
        valor.setCellValueFactory(
                new PropertyValueFactory<Agendamento, Double>("valor"));
        estadoCol.setCellValueFactory(
                new PropertyValueFactory<Agendamento, String>("tag"));
        idCol.setCellValueFactory(
                new PropertyValueFactory<Agendamento, Integer>("idAgendamento"));
        nomeServicoCol.setCellValueFactory(
                new PropertyValueFactory<Agendamento, String>("nomeServico"));

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

    private void updateFilteredData() {
        filteredData.clear();

        for (Agendamento p : masterData) {
            if (matchesFilter(p)) {
                filteredData.add(p);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }

    private boolean matchesFilter(Agendamento person) {
        String filterString = filtroTxt.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (person.getCliente().getNomeCliente().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getAnimal().getNomeAnimal().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getTag().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getNomeServico().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        }

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<Agendamento, ?>> sortOrder = new ArrayList<>(tabelaProduto.getSortOrder());
        tabelaProduto.getSortOrder().clear();
        tabelaProduto.getSortOrder().addAll(sortOrder);
    }
}