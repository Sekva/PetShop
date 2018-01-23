package org.grupin.repo.contratos;

import org.grupin.entidades.Agendamento;

import java.util.ArrayList;

public interface IRepoAgendamentos {

    public void adicionar(Agendamento a) throws Exception;
    public void mudarTag(String novaTag , int idAgendamento) throws Exception;
    public ArrayList<Agendamento> listar() throws Exception;
    public void reescrever() throws Exception;

}
