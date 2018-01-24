package org.grupin.repo.contratos;

import org.grupin.entidades.Servico;

import java.util.ArrayList;

public interface IRepoServicos {

    public void adicionar(Servico servico) throws Exception;
    public Servico remover(Servico p) throws Exception;
    public ArrayList<Servico> listar() throws Exception;
    public Servico acharServico(String referencia) throws Exception;

}
