package org.grupin.entidades;
import java.util.Random;


/** Classe para objetos da classe Animal, onde serão contidas informacoes para este.
 * @author Jose Diego
 * @author Matheus Machado
 * @author Caio Cezar
 * */
public class Cliente {

    private final int idCliente;
    private Endereco endereco;
    private Animal animal;
    private String nomeCliente;
    private String telefone;
    private String cpfCnpjCliente;

    /** Um objeto do tipo Cliente pode ser inicializado apenas com as informacoes mais basicas,
     * ou ainda com as informacoes opcionais animal e endereco. Cada opcao faz mais sentido
     * dentro de um contexto específico.
     * @param nomeCliente - Nome do cliente.
     * @param telefone - Telefone para contato.
     * @param cpfCnpjCliente - Documento do cliente.
     * @param animal - Animal ao qual um ou mais servicos serão prestados.
     * @param endereco Endereco - Endereco de residencia do cliente.
     */
    public Cliente(String nomeCliente, String telefone, String cpfCnpjCliente, Animal animal, Endereco endereco) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.idCliente = new Random().nextInt();
        this.animal = animal;
        this.endereco = endereco;
    }

    public Cliente(String nomeCliente, String telefone, String cpfCnpjCliente, Animal animal){
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.idCliente = new Random().nextInt();
        this.animal = animal;
        this.endereco = null;

    }

    public Cliente(String nomeCliente, String telefone, String cpfCnpjCliente) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.idCliente = new Random().nextInt();
    }



    /** Metodo para retorno de id do cliente
     * @return int idCliente*/
    public int getIdCliente() {
        return this.idCliente;
    }


    /** Metodo para retorno de endereco de residencia do cliente
     * @return Endereco endereco*/
    public Endereco getEndereco() {
        return this.endereco;
    }


    /** Metodo para modificacao de endereco de residencia do cliente
     * @param endereco*/
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    /** Metodo para retorno de objeto animal do cliente
     * @return animal*/
    public Animal getAnimal() {
        return this.animal;
    }


    /** Metodo para modificacao do objeto animal do cliente
     * @param animal*/
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


    /** Metodo para retoro do nome do cliente
     * @return nomeCliente
     */
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