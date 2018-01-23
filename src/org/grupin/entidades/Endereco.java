//relevância a ser questionada, talvez excluir

package org.grupin.entidades;
public class Endereco {

    private final String lagradouro;
    private final String numero;
    private final String bairro;
    private final String cidade;
    private final String estado;
    private final String cep;


    public Endereco(String lagradouro, String numero, String bairro, String cidade, String estado, String cep) {
        this.lagradouro = lagradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;

    }
}

