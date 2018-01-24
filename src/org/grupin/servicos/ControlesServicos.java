package org.grupin.servicos;

import org.grupin.entidades.Produto;
import org.grupin.entidades.Servico;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.ProdutoNaoEncontradoException;
import org.grupin.exceptions.ReferenciaInvalidaException;
import org.grupin.repo.RepoServicos;
import org.grupin.repo.contratos.IRepoServicos;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ControlesServicos {


    private final IRepoServicos repo;
    private ArrayList<Servico> todosProdutos;

    public ControlesServicos() {
        this.repo = new RepoServicos();
    }

    public void adicionarServico(Servico servico)  throws ArquivoNaoEscitoException, ReferenciaInvalidaException {

        String refencia = servico.getReferenciaProduto();

        try {

            if(this.repo.acharServico(refencia) != null) {
                throw new ReferenciaInvalidaException();
            } else {
                this.repo.adicionar(servico);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ArquivoNaoEscitoException();
        }




    }

    public Servico removerServico(String referencia) throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {

        try {

            Servico p = this.repo.acharServico(referencia);

            if(p == null) {
                throw new ProdutoNaoEncontradoException(referencia);
            }

            this.repo.remover(p);

            return p;


        } catch (ProdutoNaoEncontradoException e) {
            throw new ProdutoNaoEncontradoException(referencia);
        } catch (FileNotFoundException e) {
            throw new ArquivoNaoEscitoException();
        } catch (UnsupportedEncodingException e) {
            throw new ArquivoNaoEscitoException();
        }  catch (Exception e) {
            throw new ArquivoNaoEscitoException();
        }

    }


    public ArrayList<Servico> getTodosServicos() throws ArquivoNaoEscitoException {

        try {
            this.todosProdutos = this.repo.listar();
            return this.todosProdutos;

        } catch (Exception e) {
            throw  new ArquivoNaoEscitoException();
        }



    }

    public Servico pegarServico(String referencia) throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {

        Servico p = null;
        try {

            p = this.repo.acharServico(referencia);

        } catch (Exception e) {
            System.out.println("aqui");
            e.printStackTrace();

            throw new ArquivoNaoEscitoException();
        }

        if(p == null) {
            throw  new ProdutoNaoEncontradoException(referencia);
        }

        return  p;
    }

}
