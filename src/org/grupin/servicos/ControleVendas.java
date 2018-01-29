package org.grupin.servicos;

import org.grupin.entidades.Venda;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.NumVendaInvalidoException;
import org.grupin.repo.RepoVendas;
import org.grupin.repo.contratos.IRepoVendas;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Classe para controle de listagem de vendas
 * @author Matheus Machado Vieira
 * @see org.grupin.entidades.Venda
 */
public class ControleVendas {

    public final IRepoVendas repo;
    private ArrayList<Venda> todasVendas;

    public ControleVendas() {
        this.repo = new RepoVendas();
    }

    /**
     * Metodo para adição de nova venda realizada ao repositorio
     * @param venda Venda a ser adicionada
     * @throws ArquivoNaoEscitoException
     * @throws NumVendaInvalidoException
     */
    public void addVenda(Venda venda)  throws ArquivoNaoEscitoException, NumVendaInvalidoException{


        this.todasVendas = this.getTodasVendas();
        int numVenda = venda.getNumVenda();

        try {
            if(this.repo.pegarVenda(numVenda) != null) {
                throw new NumVendaInvalidoException(numVenda);
            } else {
                this.repo.adicionar(venda);
            }
        } catch(FileNotFoundException e ) {

            throw new ArquivoNaoEscitoException();

        } catch(UnsupportedEncodingException excep) {
            throw new ArquivoNaoEscitoException();

        }catch(Exception excep){
            throw new ArquivoNaoEscitoException();

        }



    }

    /**
     * Metodo que retorna todas as vendas por meio da arraylist de vendas
     * @return {@code ArrayList<Venda>}
     * @throws ArquivoNaoEscitoException
     */
    public ArrayList<Venda> getTodasVendas() throws ArquivoNaoEscitoException{
        try {
            this.todasVendas = this.repo.listar();
            return this.todasVendas;
        } catch (Exception excep) {
            //IGNORE System.out.println("AQUIIIIII");
            excep.printStackTrace();
            //IGNORE System.out.println("AQUIIIIII");

            throw new ArquivoNaoEscitoException();
        }
    }
}
