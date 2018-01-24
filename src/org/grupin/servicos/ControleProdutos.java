package org.grupin.servicos;

import org.grupin.entidades.Produto;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.ProdutoNaoEncontradoException;
import org.grupin.repo.RepoProdutos;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ControleProdutos {

    private final RepoProdutos repo;
    private ArrayList<Produto> todosProdutos;

    public ControleProdutos() {
        this.repo = new RepoProdutos();
    }

    public void adicionarProduto(Produto produto)  throws ArquivoNaoEscitoException {

        String refencia = produto.getReferenciaProduto();

        try {
            this.repo.adicionar(produto);

        } catch (Exception excep) {
            excep.printStackTrace();
            throw new ArquivoNaoEscitoException();
        }




    }

    public Produto removerProduto(String referencia) throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {

        try {

            Produto p = this.repo.acharProduto(referencia);

            if(p == null) {
                throw new ProdutoNaoEncontradoException(referencia);
            }




            if(p.getQuantidadeProduto() == 1) {
                this.repo.remover(p);
            } else {
                this.repo.remover(p);
                p.setQuantidadeProduto(p.getQuantidadeProduto() - 1);
                this.repo.adicionar(p);
            }

            return p;


        } catch (ProdutoNaoEncontradoException excep) {
            throw new ProdutoNaoEncontradoException(referencia);
        } catch (FileNotFoundException excep) {
            throw new ArquivoNaoEscitoException();
        } catch (UnsupportedEncodingException excep) {
            throw new ArquivoNaoEscitoException();
        } catch (Exception excep) {
            throw new ArquivoNaoEscitoException();
        }

    }


    public ArrayList<Produto> getTodosProdutos() throws ArquivoNaoEscitoException {

        try {
            this.todosProdutos = this.repo.listar();
            return this.todosProdutos;

        } catch (Exception excep) {
            throw  new ArquivoNaoEscitoException();
        }



    }

    public Produto pegarProduto(String referencia) throws ArquivoNaoEscitoException {
        Produto p = null;
        try {

            p = this.repo.acharProduto(referencia);

        } catch (Exception excep) {

            throw new ArquivoNaoEscitoException();
        }


        return  p;
    }
}
