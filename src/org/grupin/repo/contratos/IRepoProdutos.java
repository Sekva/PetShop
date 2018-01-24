package org.grupin.repo.contratos;

import org.grupin.entidades.Produto;

import java.util.ArrayList;


public interface IRepoProdutos {

    public void adicionar(Produto produto) throws Exception;
    public Produto remover(Produto produto) throws Exception;
    public ArrayList<Produto> listar() throws Exception;
    public Produto acharProduto(String referencia) throws Exception;

}
