package org.grupin.servicos;

import org.grupin.entidades.Agendamento;
import org.grupin.exceptions.AgendamentoInvalidoPorId;
import org.grupin.exceptions.AgendamentoNaoEncontradoException;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.repo.RepoAgendamentos;
import org.grupin.repo.contratos.IRepoAgendamentos;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ControleAgendamentos {

    private final IRepoAgendamentos repo;


    public ControleAgendamentos() {
        this.repo = new RepoAgendamentos();
    }

    public void addAgendamento(Agendamento agendamento)  throws ArquivoNaoEscitoException, AgendamentoInvalidoPorId {


        if(this.pegarAgendamento(agendamento.getIdAgendamento()) != null) {
            throw new AgendamentoInvalidoPorId();
        } else {
            try {
                this.repo.adicionar(agendamento);
            } catch (Exception e) {
                throw new ArquivoNaoEscitoException();
            }

        }



    }


    public Agendamento mudarTag(int idAgendamento, String novaTag) throws ArquivoNaoEscitoException, AgendamentoNaoEncontradoException {

        Agendamento a = null;
        try {

            this.repo.mudarTag(novaTag, idAgendamento);
            a = this.repo.buscarAgendamento(idAgendamento);

        }  catch (Exception e) {

            throw new ArquivoNaoEscitoException();

        }

        return a;
    }


    public Agendamento pegarAgendamento(int idAgendamento) throws ArquivoNaoEscitoException {


        try {
            Agendamento a = this.repo.buscarAgendamento(idAgendamento);
            return a;
        } catch (Exception e) {
            throw new ArquivoNaoEscitoException();
        }




    }

    public ArrayList<Agendamento> listarAgendamentos() {
        try {
            return this.repo.listar();
        } catch (Exception e) {
            return null;
        }
    }

}
