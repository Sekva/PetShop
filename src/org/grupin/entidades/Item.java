package org.grupin.entidades;
import java.util.Random;

/** Classe abstrata Item, para definicao de atributos e metodos que sera aproveitado na classe Servico
 * @author Matheus Machado
 */
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


    /** Metodo para retorno de identificador unico do produto
     * @return int - idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }


    /** Metodo para retorno do nome do produto
     * @return String - nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }


    /** Metodo para modificacao do nome do produto
     * @param nomeProduto String - Novo nome para o produto
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    /** Metodo para retorno da referencia do produto
     * @return String - referenciaProduto
     */
    public String getReferenciaProduto() {
        return referenciaProduto;
    }


    /** Metodo para modificacao da referencia do produto
     * @param referenciaProduto String - Nova referencia para o produto
     */
    public void setReferenciaProduto(String referenciaProduto) {
        this.referenciaProduto = referenciaProduto;
    }


    /** Metodo para retorno do valor do produto no momento de compra com o fornecedor
     * @return double - valorProdutoCompra
     */
    public double getValorProdutoCompra() {
        return valorProdutoCompra;
    }


    /** Metodo para modificacao do valor do produto no momento de compra com o fornecedor
     * @param valorProdutoCompra double - Valor atualizado do produto
     */
    public void setValorProdutoCompra(double valorProdutoCompra) {
        this.valorProdutoCompra = valorProdutoCompra;
    }


    /** Metodo para retorno do valor do produto no momento de venda para o cliente
     * @return double - valorProdutoVenda
     */
    public double getValorProdutoVenda() {
        return valorProdutoVenda;
    }


    /** Metodo para modificacao do valor do produto no momento da venda para o cliente
     * @param valorProdutoVenda double - Novo valor do produto
     */
    public void setValorProdutoVenda(double valorProdutoVenda) {
        this.valorProdutoVenda = valorProdutoVenda;
    }


    /** Metodo para retorno da categoria do produto
     * @return String - categoriaProduto
     */
    public String getCategoriaProduto() {
        return categoriaProduto;
    }


    /** Metodo para modificacao da categoria do produto
     * @param categoriaProduto String - Categoria atualizada do produto
     */
    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
}
