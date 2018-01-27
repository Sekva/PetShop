package org.grupin.entidades;



public class Produto extends Item{

    private int quantidadeProduto;


    public Produto(String nomeProduto, String referenciaProduto, double valorProdutoCompra, double valorProdutoVenda, String categoriaProduto, int quantidadeProduto){
        super(nomeProduto, referenciaProduto, valorProdutoCompra, valorProdutoVenda, categoriaProduto);
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }


}
