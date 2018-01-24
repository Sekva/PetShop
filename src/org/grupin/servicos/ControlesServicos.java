package org.grupin.servicos;

import org.grupin.entidades.Servico;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.ProdutoNaoEncontradoException;
import org.grupin.exceptions.ReferenciaInvalidaException;
import org.grupin.repo.RepoServicos;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ControlesServicos {


    private final RepoServicos repo;
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

        } catch (Exception excep) {
            excep.printStackTrace();
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


    public ArrayList<Servico> getTodosServicos() throws ArquivoNaoEscitoException {

        try {
            this.todosProdutos = this.repo.listar();
            return this.todosProdutos;

        } catch (Exception excep) {
            throw  new ArquivoNaoEscitoException();
        }



    }

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
