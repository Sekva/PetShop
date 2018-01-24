package org.grupin.repo.contratos;

import org.grupin.entidades.Agendamento;
import org.grupin.exceptions.AgendamentoNaoEncontradoException;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public interface IRepoAgendamentos {

    public void adicionar(Agendamento a) throws Exception;
    public void mudarTag(String novaTag , int idAgendamento) throws Exception;
    public ArrayList<Agendamento> listar() throws Exception;
    public Agendamento buscarAgendamento(int idAgendamento) throws Exception;

}
