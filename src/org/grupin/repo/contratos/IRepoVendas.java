package org.grupin.repo.contratos;

import org.grupin.entidades.Venda;

import java.util.ArrayList;

/**
 * Classe de interface para outras possiveis implementações
 * para repositorio de vendas
 * @author Matheus Machado Vieira
 */


public interface IRepoVendas {


    /**
     * Metodo de adição de nova venda
     * @param v venda a ser adicionada
     * @throws Exception
     */
    public void adicionar(Venda v) throws Exception;

    /**
     * Metodo de listagem para recriar o arraylist
     * @return {@code ArrayList<Venda>}
     * @throws Exception
     */
    public ArrayList<Venda> listar() throws Exception;

    /**
     * Metodo  de busca para vendas
     * @param idVenda numero da venda a ser buscada
     * @return {@code Venda}
     * @throws Exception
     */
    public Venda pegarVenda(int idVenda) throws Exception;

}
