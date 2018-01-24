package org.grupin.repo.contratos;

import org.grupin.entidades.Venda;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface IRepoVendas {

    public void adicionar(Venda v) throws Exception;
    public ArrayList<Venda> listar() throws Exception;
    public Venda pegarVenda(int idVenda) throws Exception;

}
