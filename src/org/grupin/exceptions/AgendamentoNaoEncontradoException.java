package org.grupin.exceptions;

public class AgendamentoNaoEncontradoException extends Exception {

    public AgendamentoNaoEncontradoException(int idAgendamento) {

        super("O agendamento para " + idAgendamento + "não foi encontrado");

    }

}
