package org.grupin.exceptions;

public class ProdutoNaoEncontradoException extends Exception {

    public ProdutoNaoEncontradoException(String referencia) {
        super("O produto de referencia " + referencia + " não foi encontrado");
    }

}
