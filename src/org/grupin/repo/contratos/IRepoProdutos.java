package org.grupin.repo.contratos;

import org.grupin.entidades.Produto;

import java.util.ArrayList;

/**
 * Classe de interface para outras possiveis implementações
 * para repositorio de produtos
 * @author Matheus Machado Vieira
 */


public interface IRepoProdutos {

    /**
     * Metodo de adição de novo produto
     * @param produto produto a ser adicionado
     * @throws Exception
     */
    public void adicionar(Produto produto) throws Exception;

    /**
     * Metodo para remover todos o objeto de produto
     * @param produto produto a ser removido
     * @return
     * @throws Exception
     */
    public Produto remover(Produto produto) throws Exception;

    /**
     * Recria o arraylist dos produtos para uso interno e externo
     * @return {@code ArrayList<Produto>}
     * @throws Exception
     */
    public ArrayList<Produto> listar() throws Exception;

    /**
     * Busca um unico produto a partir do intentificador
     * @param referencia numero de referencia do produto a ser encontrado
     * @return {@code Produto}
     * @throws Exception
     */
    public Produto acharProduto(String referencia) throws Exception;

}
