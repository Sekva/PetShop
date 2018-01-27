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


    /** Alguns metodos ja implementados em outras classes:
     * gambiarra pra GUI funcionar
     * revisao mais tarde :3
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


    /** Metodo para correcao do nome do animal ao qual sera prestado servico
     * @param nomeAnimal String - Nome corrigido do animal
     */
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }


    /** Metodo para retorno de id do agendamento de servico
     * @return int - idAgendamento
     */
    public int getIdAgendamento() {
        return this.idAgendamento;
    }



    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public String getDataMarcada() {
        return this.dataMarcada;
    }

    public void setDataMarcada(String dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    public Date getDataDeExpedicao() {
        return this.dataDeExpedicao;
    }

    public void setDataDeExpedicao(Date dataDeExpedicao) {
        this.dataDeExpedicao = dataDeExpedicao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
