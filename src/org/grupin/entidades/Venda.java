package org.grupin.entidades;
import java.util.Date;


/** Classe para objetos da classe Venda, que contem as informacoes e metodos deste.
 * @author Jose Diego
 * @author Caio Cezar
 */
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


    /** Metodo para retorno da data da venda do produto
     * @return Date - data
     */
    public Date getData() {
        return data;
    }


    /** Metodo para retorno do nome do cliente que requisitou o produto
     * @return String - nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }


    /** Metodo para retorno do nome do produto da venda
     * @return String - nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }


    /** Metodo para retorno do valor do produto da venda
     * @return double - valorProduto
     */
    public double getValorProduto() {
        return valorProduto;
    }


    /** Metodo para retorno do numero da venda
     * @return int - numVenda
     */
    public int getNumVenda() {
        return numVenda;
    }


    /** Metodo para retorno do objeto Produto da venda
     * @return Produto - produto
     */
    public Produto getProduto() {
        return produto;
    }


    /** Metodo para retorno do objeto Cliente da Venda
     * @return Cliente - cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

}
