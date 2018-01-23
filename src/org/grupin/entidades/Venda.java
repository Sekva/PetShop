package org.grupin.entidades;

import java.util.Date;

public class Venda {

    private final Date data;
    private final int numVenda;
    private final Produto produto;
    private final Cliente cliente;
    private final String nomeCliente;
    private final String nomeProduto;
    private final double valorProduto;

    public Venda(Produto produto, int numVenda, Cliente cliente) {
        this.numVenda = numVenda;
        this.data = new Date();
        this.produto = produto;
        this.cliente = cliente;

        this.nomeCliente = cliente.getNomeCliente();
        this.nomeProduto = produto.getNomeProduto();
        this.valorProduto = produto.getValorProdutoVenda();

    }

    public Date getData() {
        return data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public int getNumVenda() {
        return numVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
