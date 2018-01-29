package org.grupin.servicos;

import org.grupin.entidades.Produto;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.ProdutoNaoEncontradoException;
import org.grupin.repo.RepoProdutos;
import org.grupin.repo.contratos.IRepoProdutos;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/** Classe para controle de dados de Produtos.
 * @author Matheus Machado
 * @see org.grupin.entidades.Produto
 */
public class ControleProdutos {

    private final IRepoProdutos repo;
    private ArrayList<Produto> todosProdutos;

    public ControleProdutos() {
        this.repo = new RepoProdutos();
    }

    /**
     * Metodo que recebe o produto a ser adicionado
     * @param produto produto a ser adicionado
     * @throws ArquivoNaoEscitoException
     */
    public void adicionarProduto(Produto produto)  throws ArquivoNaoEscitoException {

        String refencia = produto.getReferenciaProduto();

        try {
            this.repo.adicionar(produto);

        } catch (Exception excep) {
            excep.printStackTrace();
            throw new ArquivoNaoEscitoException();
        }




    }

    /**
     * Metodo de remoção de um unico produto.
     * Uma vez que cada obejeto produto possui o atributo quantidade,
     * este metodos diminui em 1 o atributo quantidade e salva de volta
     * no repositorio.
     * @see Produto
     * @param referencia referencia do prouduto a ser removido
     * @return {@code Produto}
     * @throws ArquivoNaoEscitoException
     * @throws ProdutoNaoEncontradoException
     */
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

    /**
     * Metodo que retorna todos os objetos de produto presentes no repositorio
     * @return {@code ArrayList<Produto>}
     * @throws ArquivoNaoEscitoException
     */
    public ArrayList<Produto> getTodosProdutos() throws ArquivoNaoEscitoException {

        try {
            this.todosProdutos = this.repo.listar();
            return this.todosProdutos;

        } catch (Exception excep) {
            throw  new ArquivoNaoEscitoException();
        }



    }

    /**
     * Metodo que retorna um unico produto a partir de referencia
     * @param referencia Referencia do produto buscado
     * @return {@code Produto}
     * @throws ArquivoNaoEscitoException
     */
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
