package org.grupin.repo.contratos;

import org.grupin.entidades.Servico;

import java.util.ArrayList;

/**
 * Classe de interface para outras possiveis implementações
 * para repositorio de servicos
 * @author Matheus Machado Vieira
 */


public interface IRepoServicos {

    /**
     * Metodo de adição de novo servico
     * @param servico servico a ser adicionado
     * @throws Exception
     */
    public void adicionar(Servico servico) throws Exception;

    /**
     * Metodo para remover todos o objeto de Servico
     * @param s servico a ser removido
     * @return {@code Servico}
     * @throws Exception
     */
    public Servico remover(Servico s) throws Exception;

    /**
     * Recria o arraylist dos servicos para uso interno e externo
     * @return {@code ArrayList<Servico>}
     * @throws Exception
     */
    public ArrayList<Servico> listar() throws Exception;

    /**
     * Busca um unico Servico a partir do intentificador
     * @param referencia
     * @return {@code Servico}
     * @throws Exception
     */
    public Servico acharServico(String referencia) throws Exception;

}
