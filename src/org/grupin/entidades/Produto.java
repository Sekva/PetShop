package org.grupin.entidades;
import java.util.Random;


/** Classe para objetos do tipo Produto, que contera informacoes e metodos para este
 * @author Jose Diego
 * @author Caio Cezar
 */
public class Produto extends Item {

    private int quantidadeProduto;


    public Produto(String nomeProduto, String referenciaProduto, double valorProdutoCompra, double valorProdutoVenda, String categoriaProduto, int quantidadeProduto){
        super(nomeProduto, referenciaProduto, valorProdutoCompra, valorProdutoVenda, categoriaProduto);
        this.quantidadeProduto = quantidadeProduto;
    }


    /** Metodo para retorno da quantidade do produto em estoque
     * @return int - quantidadeProduto
     */
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }


    /** Metodo para atualizar a quantidade do produto em estoque
     * @param quantidadeProduto int - Quantidade atualizada de produtos no estoque
     */
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }




}
