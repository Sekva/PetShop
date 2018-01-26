package org.grupin.entidades;
import java.util.Random;

/** Classe para objetos do tipo Animal, onde serão contidas informacoes para este.
 * @author Jose Diego
 * @author Caio Cezar
 */
public class Animal {

    private int idAnimal;
    private String nomeAnimal;
    private String tipoAnimal;
    private String racaAnimal;

    public Animal(String nomeAnimal, String tipoAnimal, String racaAnimal) {
        this.idAnimal = new Random().nextInt();
        this.nomeAnimal = nomeAnimal;
        this.tipoAnimal = tipoAnimal;
        this.racaAnimal = racaAnimal;

    }

    /** Metodo para retorno do id do animal
     * @return int - idAnimal*/
    public int getIdAnimal() {
        return this.idAnimal;
    }


    /** Metodo para retorno do nome do animal
     * @return String - nomeAnimal*/
    public String getNomeAnimal() {
        return this.nomeAnimal;
    }


    /** Metodo para modificacao de nome do animal
     * @param nomeAnimal - Novo nome do animal*/
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }


    /** Metodo para retorno do tipo do animal
     * @return String - tipoAnimal*/
    public String getTipoAnimal() {
        return this.tipoAnimal;
    }


    /**Metodo para retorno da raca do animal
     * @return String - racaAnimal*/
    public String getRacaAnimal() {
        return this.racaAnimal;
    }

}
