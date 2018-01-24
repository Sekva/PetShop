package org.grupin.entidades;


import java.util.Random;

public class Cliente {

    private final int idCliente;
    private Endereco endereco;
    private Animal animal;          //talvez mudar para um ArrayList de animais.
    private String nomeCliente;
    private String telefone;
    private String cpfCnpjCliente;

    public Cliente(String nomeCliente, String telefone, String cpfCnpjCliente, Animal animal){
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.idCliente = new Random().nextInt();
        this.animal = animal;
        this.endereco = null;

    }

    public Cliente(String nomeCliente, String telefone, String cpfCnpjCliente, Animal animal, Endereco endereco) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.idCliente = new Random().nextInt();
        this.animal = animal;
        this.endereco = endereco;
    }

    public Cliente(String nomeCliente, String telefone, String cpfCnpjCliente) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.idCliente = new Random().nextInt();
    }


    public int getIdCliente() {
        return this.idCliente;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public java.lang.String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(java.lang.String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public java.lang.String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(java.lang.String telefone) {
        this.telefone = telefone;
    }

    public java.lang.String getCpfCnpjCliente() {
        return this.cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(java.lang.String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }


}