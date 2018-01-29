package org.grupin.repo.contratos;

import org.grupin.entidades.Agendamento;

import java.util.ArrayList;

/**
 * Classe de interface para outras possiveis implementações
 * para repositorio de agendamentos
 * @author Matheus Machado Vieira
 */

public interface IRepoAgendamentos {

    /**
     * Metodo de adição de novo agendamento
     * @param a agendamento a ser adicionado
     * @throws Exception
     */
    public void adicionar(Agendamento a) throws Exception;

    /**
     * Metodo para mudar a tag(estado) de dado agendamento
     * a partir do numero de indentificação
     * @param novaTag novo estado do dado agendamento
     * @param idAgendamento numero de agendamento a ser achado
     * @throws Exception
     */
    public void mudarTag(String novaTag , int idAgendamento) throws Exception;

    /**
     * Recria o arraylist dos agendamentos para uso interno e externo
     * @return {@code ArrayList<Agendamento>}
     * @throws Exception
     */
    public ArrayList<Agendamento> listar() throws Exception;

    /**
     * Busca um unico agendamento a partir do intentificador
     * @param idAgendamento numero de agendamento a ser achado
     * @return {@code Agendamento}
     * @throws Exception
     */
    public Agendamento buscarAgendamento(int idAgendamento) throws Exception;

}
