package org.grupin.entidades;
import java.util.Date;
import java.util.Random;

/** Classe para objetos da classe Agendamento, onde serão contidas informacoes para este.
 * @author Caio Cezar
 * @author Matheus Machado
 * */

public class Agendamento {

    private int idAgendamento;
    private String dataMarcada;
    private Date dataDeExpedicao;
    private Servico servico;
    private Cliente cliente;
    private Animal animal;
    private String tag;

    private double valor;
    private String nomeCliente, nomeAnimal, nomeServico;

    public Agendamento(Cliente c, String dataMarcada, Servico servico) {
        this.servico = servico;
        this.cliente = c;
        this.idAgendamento = new Random().nextInt();
        this.dataDeExpedicao = new Date();
        this.dataMarcada = dataMarcada;
        this.animal = c.getAnimal();
        this.tag = "Espera";

        this.valor = servico.getValorProdutoVenda();
        this.nomeCliente = c.getNomeCliente();
        this.nomeAnimal = c.getAnimal().getNomeAnimal();
        this.nomeServico = servico.getNomeProduto();

    }


    /** Alguns metodos ja implementados em outras classes
     * gambiarra pra GUI funcionar
     * revisao mais tarde
     */

    /** Metodo para retorno da identificacao do servico
     * @return String - nomeServico
     */
    public String getNomeServico() {
        return nomeServico;
    }


    /** Metodo para modificacao de identificacao do servico
     * @param nomeServico String - Novo nome do servico
     */
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }


    /** Metodo para retorno do preco do servico prestado
     * @return double - valor
     */
    public double getValor() {
        return valor;
    }


    /** Metodo para modificacao do preco do servico prestado
     * @param valor double - Novo preco do servico
     */
    public void setValor(double valor) {
        this.valor = valor;
    }


    /** Metodo para retorno do nome do cliente que requisitou o servico
     * @return String - nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }


    /** Metodo para correcao do nome do cliente que requisitou o servico
     * @param nomeCliente String - Nome corrigido do cliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }


    /** Metodo para retorno do nome do animal ao qual sera prestado servico
     * @return String - nomeAnimal
     */
    public String getNomeAnimal() {
        return nomeAnimal;
    }


    /** Metodo para retorno de id do agendamento de servico
     * @return int - idAgendamento
     */
    public int getIdAgendamento() {
        return this.idAgendamento;
    }


    /** Metodo para retorno da data marcada para o servico
     * @return String - dataMarcada
     */
    public String getDataMarcada() {
        return this.dataMarcada;
    }


    /** Metodo para modificacao de data programada do servico
     * @param dataMarcada String - Nova data estipulada para realizacao do servico
     */
    public void setDataMarcada(String dataMarcada) {
        this.dataMarcada = dataMarcada;
    }


    /** Metodo para retorno da data em que foi feito o agendamento do servico
     * @return dataDeExpedicao
     */
    public Date getDataDeExpedicao() {
        return this.dataDeExpedicao;
    }


    /** Metodo para retorno do servico requisitado
     * @return String - servico
     */
    public Servico getServico() {
        return servico;
    }


    /** Metodo para modificacao de servico a ser realizado
     * @param servico Servico - Novo servico que sera realizado
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }


    /** Metodo para retorno do cliente que requisitou o servico
     * @return Cliente - cliente
     */
    public Cliente getCliente() {
        return this.cliente;
    }


    /** Metodo para retorno do animal que recebera o servico
     * @return Animal - animal
     */
    public Animal getAnimal() {
        return this.animal;
    }

    /** Metodo para alteracao de qual animal recebera o servico
     * @param animal Animal - Novo animal que passara a receber o servico
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    /** Metodo para retorno do status(tag) do servico
     * @return String - tag
     */
    public String getTag() {
        return this.tag;
    }


     /** Metodo para modificacao do status (tag) do servico
     * @param tag String - Status atualizado do servico
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
