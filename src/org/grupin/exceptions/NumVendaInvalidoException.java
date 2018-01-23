package org.grupin.exceptions;

public class NumVendaInvalidoException extends Exception {

    public NumVendaInvalidoException(int id) {
        super("Numero de venda invalido, id:" + id);
    }

}
