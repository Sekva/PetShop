package org.grupin.servicos;

import org.grupin.entidades.Venda;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.exceptions.NumVendaInvalidoException;
import org.grupin.repo.RepoVendas;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ControleVendas {

    public final RepoVendas repo;
    private ArrayList<Venda> todasVendas;

    public ControleVendas() {
        this.repo = new RepoVendas();
    }


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

        } catch(UnsupportedEncodingException e){

            throw new ArquivoNaoEscitoException();


        }



    }





    public ArrayList<Venda> getTodasVendas() throws ArquivoNaoEscitoException{
        try {
            this.todasVendas = this.repo.listar();
            return this.todasVendas;
        } catch (Exception e) {
            System.out.println("AQUIIIIII");
            e.printStackTrace();
            System.out.println("AQUIIIIII");

            throw new ArquivoNaoEscitoException();
        }
    }
}
