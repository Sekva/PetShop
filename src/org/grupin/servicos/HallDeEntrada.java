package org.grupin.servicos;

import org.grupin.entidades.*;
import org.grupin.exceptions.*;

import java.util.ArrayList;
import java.util.Date;


public class HallDeEntrada {

    private final ControleAgendamentos controleAgendamentos;
    private final ControleProdutos controleProdutos;
    private final ControlesServicos controleServicos;
    private final ControleVendas controleVendas;

    public HallDeEntrada() {
        this.controleAgendamentos = new ControleAgendamentos();
        this.controleProdutos = new ControleProdutos();
        this.controleServicos = new ControlesServicos();
        this.controleVendas = new ControleVendas();
    }


    //####################################################################################################################################################################

    // FUNCIONALIDADES


    public void mudarStatusAgendamento(int idAgendamento, String novoEstado) throws ArquivoNaoEscitoException, AgendamentoNaoEncontradoException {
        this.controleAgendamentos.mudarTag(idAgendamento, novoEstado);
    }

    public Agendamento pegarAgendamento(int idAgendamento) throws ArquivoNaoEscitoException, AgendamentoNaoEncontradoException {
        Agendamento a = this.controleAgendamentos.pegarAgendamento(idAgendamento);
        return a;
    }

    public ArrayList<Agendamento> listarAgendamentos() {
        System.out.println("aqui 1");
        return this.controleAgendamentos.listarAgendamentos();
    }

    public Produto pegarProduto(String referencia)throws ArquivoNaoEscitoException {

        Produto p = null;

        try {
            p = this.controleProdutos.pegarProduto(referencia);
        } catch (Exception excep) {
            throw new ArquivoNaoEscitoException();
        }

        return p;


    }

    public Servico pegarServico(String referencia)throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {
        Servico s = this.controleServicos.pegarServico(referencia);
        return s;
    }

    public ArrayList<Produto> listarProdutos() throws ArquivoNaoEscitoException{
        return this.controleProdutos.getTodosProdutos();
    }

    public ArrayList<Servico> listarServicos() throws ArquivoNaoEscitoException{
        return this.controleServicos.getTodosServicos();
    }

    public ArrayList<Venda> listarVendas() throws ArquivoNaoEscitoException {
        return this.controleVendas.getTodasVendas();
    }


    // FUNCIONALIDADES

    //####################################################################################################################################################################

    //REGISTRO DE ITENS


    public void registrarProduto(Produto p) throws ArquivoNaoEscitoException {
        this.controleProdutos.adicionarProduto(p);
    }

    public void removerProduto(String refenciaProduto) throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {
        this.controleProdutos.removerProduto(refenciaProduto);
    }

    public void registrarServico(Servico s) throws ArquivoNaoEscitoException, ReferenciaInvalidaException {
        this.controleServicos.adicionarServico(s);
    }

    public void removerServico(String referenciaServico) throws ArquivoNaoEscitoException, ProdutoNaoEncontradoException {
        this.controleServicos.removerServico(referenciaServico);
    }

    public void registrarVenda(Venda v) throws ArquivoNaoEscitoException, NumVendaInvalidoException {
        this.controleVendas.addVenda(v);
    }

    public void registrarAgendamento(Agendamento a) throws ArquivoNaoEscitoException, AgendamentoInvalidoPorId {
        this.controleAgendamentos.addAgendamento(a);
    }


    //REGISTRO DE ITENS

    //####################################################################################################################################################################

    //INSTANCIACAO DE OBJETOS


    public Agendamento criarAgendamento(Cliente cliente, String dataMarcada, Servico servico) {
        return new Agendamento(cliente, dataMarcada, servico);
    }

    public Animal criarAnimal(String nomeAnimal, String tipoAnimal, String racaAnimal) {
        return new Animal(nomeAnimal, tipoAnimal, racaAnimal);
    }

    public Cliente criarCliente(String nomeCliente, String telefone, String cpfOuCnpj, Animal animal, Endereco endereco) {
        return new Cliente(nomeCliente, telefone, cpfOuCnpj, animal, endereco);
    }

    public Cliente criarCliente(String nomeCliente, String telefone, String cpfOuCnpj, Animal animal) {
        return new Cliente(nomeCliente, telefone, cpfOuCnpj, animal);
    }

    public Cliente criarCliente(String nomeCliente, String telefone, String cpfOuCnpj) {
        return new Cliente(nomeCliente, telefone, cpfOuCnpj);
    }

    public Produto criarProduto(String nomeProduto, String referenciaProduto, double valorProdutoCompra, double valorProdutoVenda, String categoriaProduto, int quantidadeProduto) {
        return new Produto(nomeProduto, referenciaProduto, valorProdutoCompra, valorProdutoVenda, categoriaProduto, quantidadeProduto);
    }

    public Venda criarVenda(Produto produto, int numVenda, Cliente cliente) {
        return new Venda(produto, numVenda, cliente);
    }

    public Servico criarServico(String nomeProduto, String referenciaProduto, double valorProdutoCompra, double valorProdutoVenda, String categoriaProduto) {
        return new Servico(nomeProduto, referenciaProduto, valorProdutoCompra, valorProdutoVenda, categoriaProduto);
    }


    //INSTANCIACAO DE OBJETOS

    //####################################################################################################################################################################

    //VALIDACOES


    public boolean validarProduto(String nomeProduto, String referenciaProduto, double valorProdutoCompra, double valorProdutoVenda, int quantidade) {

        boolean eValido = false;

        if (!nomeProduto.equals("") && !referenciaProduto.equals("") && valorProdutoCompra != 0 && valorProdutoVenda != 0 && quantidade != 0) {
            eValido = true;
        }
        return eValido;
    }

    public boolean validarServico(String nomeServico, String referenciaServico, double valorServicoCompra, double valorServicoVenda, String categoriaServico) {

        boolean eValido = false;

        if(!nomeServico.equals("") && !referenciaServico.equals("") && valorServicoCompra != 0 && valorServicoVenda != 0) {
            eValido = true;
        }
        return eValido;
    }

    public boolean validarAnimal(String nomeAnimal, String tipoAnimal, String racaAnimal) {
        boolean eValido = false;

        if (!nomeAnimal.equals("") && !tipoAnimal.equals("") && !racaAnimal.equals("")) {
            eValido = true;
        }

        return eValido;
    }

    public boolean validarCliente(String nomeCliente, String telefone, String cpfOuCnpj, Animal animal) {
        boolean eValido = false;

        if (!nomeCliente.equals("") && !telefone.equals("") && !cpfOuCnpj.equals("") && animal != null) {
            eValido = true;
        }

        return eValido;
    }

    public boolean validarCliente(String nomeCliente, String telefone, String cpfOuCnpj) {
        boolean eValido = false;

        if (!nomeCliente.equals("") && !telefone.equals("") && !cpfOuCnpj.equals("")) {
            eValido = true;
        }

        return eValido;
    }

    public boolean validarAgendamento(Cliente cliente, Date dataMarcada) {
        boolean eValido = false;

        if (cliente != null && dataMarcada != null) {
            eValido = true;
        }

        return eValido;
    }

    public boolean validarVenda(Produto produto, int numVenda, Cliente cliente) {
        boolean eValido = false;

        if (produto != null && numVenda != 0 && cliente != null) {
            eValido = true;
        }

        return eValido;
    }


    //VALIDACOES

    //####################################################################################################################################################################

}
