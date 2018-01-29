package org.grupin.servicos;

import org.grupin.entidades.Servico;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.ProdutoNaoEncontradoException;
import org.grupin.exceptions.ReferenciaInvalidaException;
import org.grupin.repo.RepoServicos;
import org.grupin.repo.contratos.IRepoServicos;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Classe para controle de servicos
 * @author Matheus Machado Vieira
 * @see org.grupin.entidades.Servico
 */
public class ControlesServicos {


    private final IRepoServicos repo;
    private ArrayList<Servico> todosServicos;

    public ControlesServicos() {
        this.repo = new RepoServicos();
    }

    /**
     * Metodo para adição de servico no repositorio
     * @param servico Servico a ser adicionado
     * @throws ArquivoNaoEscitoException
     * @throws ReferenciaInvalidaException
     */
    public void adicionarServico(Servico servico)  throws ArquivoNaoEscitoException, ReferenciaInvalidaException {

        String refencia = servico.getReferenciaProduto();

        try {

            if(this.repo.acharServico(refencia) != null) {
                throw new ReferenciaInvalidaException();
            } else {
                this.repo.adicionar(servico);
            }

        } catch (Exception excep) {
            excep.printStackTrace();
            throw new ArquivoNaoEscitoException();
        }




    }

    /**
     * Metodo para remoção de servico do repositorio
     * @param referencia Referencia do servico a ser removido
     * @return {@code Servico}
     * @throws ArquivoNaoEscitoException
     * @throws ProdutoNaoEncontradoException
     */
    public Servico removerServico(String referencia) throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {

        try {

            Servico p = this.repo.acharServico(referencia);

            if(p == null) {
                throw new ProdutoNaoEncontradoException(referencia);
            }

            this.repo.remover(p);

            return p;


        } catch (ProdutoNaoEncontradoException excep) {
            throw new ProdutoNaoEncontradoException(referencia);
        } catch (FileNotFoundException excep) {
            throw new ArquivoNaoEscitoException();
        } catch (UnsupportedEncodingException excep) {
            throw new ArquivoNaoEscitoException();
        }  catch (Exception excep) {
            throw new ArquivoNaoEscitoException();
        }

    }

    /**
     * Metodo que retorna todos os servicos listados num arraylist
     * @return {@code ArrayList<Servico>}
     * @throws ArquivoNaoEscitoException
     */
    public ArrayList<Servico> getTodosServicos() throws ArquivoNaoEscitoException {

        try {
            this.todosServicos = this.repo.listar();
            return this.todosServicos;

        } catch (Exception excep) {
            throw  new ArquivoNaoEscitoException();
        }



    }

    /**
     * Metodo de busca para um unico servico a partir da referencia
     * @param referencia Referencia do servico a ser buscado
     * @return {@code Servico}
     * @throws ArquivoNaoEscitoException
     * @throws ProdutoNaoEncontradoException
     */
    public Servico pegarServico(String referencia) throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {

        Servico p = null;
        try {

            p = this.repo.acharServico(referencia);

        } catch (Exception excep) {
            //IGNORE System.out.println("aqui");
            excep.printStackTrace();

            throw new ArquivoNaoEscitoException();
        }

        if(p == null) {
            throw  new ProdutoNaoEncontradoException(referencia);
        }

        return  p;
    }

}
