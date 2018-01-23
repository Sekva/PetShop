package org.grupin.exceptions;

import org.grupin.entidades.Venda;

public class VendaInvalidaException extends Exception {

    public VendaInvalidaException() {
        super("Informação de venda invalida");
    }

}
