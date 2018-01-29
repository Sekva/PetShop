package org.grupin.entidades;

/** Classe para objetos da classe Endereco, onde serão contidas informacoes para este.
 * @author Jose Diego
 * @author Caio Cezar
 */
public class Endereco {

    private final String logradouro;
    private final String numero;
    private final String bairro;
    private final String cidade;
    private final String estado;
    private final String cep;


    public Endereco(String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;

    }

    /** Metodo para retorno do logradouro do endereco
     * @return String - logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }


    /** Metodo para retorno do numero do endereco
     * @return String - numero
     */
    public String getNumero() {
        return numero;
    }


    /** Metodo para retorno do bairro do endereco
     * @return String - bairro
     */
    public String getBairro() {
        return bairro;
    }


    /** Metodo para retorno da cidade de endereco
     * @return String - cidade
     */
    public String getCidade() {
        return cidade;
    }


    /** Metodo para retorno do estado de endereco
     * @return String - estado
     */
    public String getEstado() {
        return estado;
    }


    /** Metodo para retorno do cep de endereco
     * @return String - cep
     */
    public String getCep() {
        return cep;
    }
}

