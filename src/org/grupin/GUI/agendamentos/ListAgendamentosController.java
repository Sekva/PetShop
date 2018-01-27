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

    private ObservableList<Agendamento> listaCompleta = FXCollections.observableArrayList();
    private ObservableList<Agendamento> listaFiltrada = FXCollections.observableArrayList();

    public ListAgendamentosController() {

        hallDeEntrada fachada = new hallDeEntrada();


        try {
            ArrayList<Agendamento> lista = fachada.listarAgendamentos();

            for (Agendamento p : lista) {
                listaCompleta.add(p);
            }

        } catch (Exception excep) {
            excep.printStackTrace();
        }

        listaFiltrada.addAll(listaCompleta);


        listaCompleta.addListener(new ListChangeListener<Agendamento>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Agendamento> change) {
                attFiltro();
            }
        });
    }

    @FXML
    private void initialize() {

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

        for (Agendamento p : listaCompleta) {
            if (verificarFiltro(p)) {
                listaFiltrada.add(p);
            }
        }


        reordenar();
    }

    private boolean verificarFiltro(Agendamento ag) {
        String stringFiltro = filtroTxt.getText();
        if (stringFiltro == null || stringFiltro.isEmpty()) {

            return true;
        }

        String filtroMinusculo = stringFiltro.toLowerCase();

        if (ag.getCliente().getNomeCliente().toLowerCase().indexOf(filtroMinusculo) != -1) {
            return true;
        } else if (ag.getAnimal().getNomeAnimal().toLowerCase().indexOf(filtroMinusculo) != -1) {
            return true;
        } else if (ag.getTag().toLowerCase().indexOf(filtroMinusculo) != -1) {
            return true;
        } else if (ag.getNomeServico().toLowerCase().indexOf(filtroMinusculo) != -1) {
            return true;
        }

        return false;
    }

    private void reordenar() {
        ArrayList<TableColumn<Agendamento, ?>> ordem = new ArrayList<>(tabelaProduto.getSortOrder());
        tabelaProduto.getSortOrder().clear();
        tabelaProduto.getSortOrder().addAll(ordem);
    }
}