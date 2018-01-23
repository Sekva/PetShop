package org.grupin.entidades;

import java.util.Date;
import java.util.Random;

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

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

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
