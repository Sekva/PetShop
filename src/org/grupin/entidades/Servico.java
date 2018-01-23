package org.grupin.entidades;

public class Servico extends Item {

    public Servico(String nomeProduto, String referenciaProduto, double valorProdutoCompra, double valorProdutoVenda, String categoriaProduto) {
        super(nomeProduto, referenciaProduto, valorProdutoCompra, valorProdutoVenda, categoriaProduto);
    }

    @Override
    public int getIdProduto() {
        return super.getIdProduto();
    }

    @Override
    public void setIdProduto(int idProduto) {
        super.setIdProduto(idProduto);
    }

    @Override
    public String getNomeProduto() {
        return super.getNomeProduto();
    }

    @Override
    public void setNomeProduto(String nomeProduto) {
        super.setNomeProduto(nomeProduto);
    }

    @Override
    public String getReferenciaProduto() {
        return super.getReferenciaProduto();
    }

    @Override
    public void setReferenciaProduto(String referenciaProduto) {
        super.setReferenciaProduto(referenciaProduto);
    }

    @Override
    public double getValorProdutoCompra() {
        return super.getValorProdutoCompra();
    }

    @Override
    public void setValorProdutoCompra(double valorProdutoCompra) {
        super.setValorProdutoCompra(valorProdutoCompra);
    }

    @Override
    public double getValorProdutoVenda() {
        return super.getValorProdutoVenda();
    }

    @Override
    public void setValorProdutoVenda(double valorProdutoVenda) {
        super.setValorProdutoVenda(valorProdutoVenda);
    }

    @Override
    public String getCategoriaProduto() {
        return super.getCategoriaProduto();
    }

    @Override
    public void setCategoriaProduto(String categoriaProduto) {
        super.setCategoriaProduto(categoriaProduto);
    }
}
