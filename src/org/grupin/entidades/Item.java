package org.grupin.entidades;

import java.util.Random;

public abstract class Item {

    private int idProduto;
    private String nomeProduto;
    private String referenciaProduto;
    private double valorProdutoCompra;
    private double valorProdutoVenda;
    private String categoriaProduto;

    public Item(String nomeProduto, String referenciaProduto, double valorProdutoCompra, double valorProdutoVenda, String categoriaProduto) {

        this.idProduto = new Random().nextInt();
        this.nomeProduto = nomeProduto;
        this.referenciaProduto = referenciaProduto;
        this.valorProdutoCompra = valorProdutoCompra;
        this.valorProdutoVenda = valorProdutoVenda;
        this.categoriaProduto = categoriaProduto;

    }


    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getReferenciaProduto() {
        return referenciaProduto;
    }

    public void setReferenciaProduto(String referenciaProduto) {
        this.referenciaProduto = referenciaProduto;
    }

    public double getValorProdutoCompra() {
        return valorProdutoCompra;
    }

    public void setValorProdutoCompra(double valorProdutoCompra) {
        this.valorProdutoCompra = valorProdutoCompra;
    }

    public double getValorProdutoVenda() {
        return valorProdutoVenda;
    }

    public void setValorProdutoVenda(double valorProdutoVenda) {
        this.valorProdutoVenda = valorProdutoVenda;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
}
