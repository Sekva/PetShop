package org.grupin.entidades;


/** Classe para objetos da classe Produto, que herda da abstrata Item seus atributos e metodos
 * @author Matheus Machado
 */
public class Servico extends Item {

    public Servico(String nomeServico, String referenciaServico, double valorProdutoCompra, double valorProdutoVenda, String categoriaServico) {
        super(nomeServico, referenciaServico, valorProdutoCompra, valorProdutoVenda, categoriaServico);
    }

}
