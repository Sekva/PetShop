package org.grupin.entidades;

import java.util.Random;

public class Animal {

    private int idAnimal;
    private String nomeAnimal;
    private String tipoAnimal;
    private String racaAnimal;

    public Animal(String nomeAnimal, String tipoAnimal, String racaAnimal) {
        this.idAnimal = new Random(10000).nextInt();
        this.nomeAnimal = nomeAnimal;
        this.tipoAnimal = tipoAnimal;
        this.racaAnimal = racaAnimal;

    }

    public int getIdAnimal() {
        return this.idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return this.nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getTipoAnimal() {
        return this.tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getRacaAnimal() {
        return this.racaAnimal;
    }

    public void setRacaAnimal(String racaAnimal) {
        this.racaAnimal = racaAnimal;
    }
}
