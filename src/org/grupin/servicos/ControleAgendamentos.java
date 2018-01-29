package org.grupin.servicos;
import org.grupin.entidades.Agendamento;
import org.grupin.exceptions.AgendamentoInvalidoPorId;
import org.grupin.exceptions.AgendamentoNaoEncontradoException;
import org.grupin.exceptions.ArquivoNaoEscitoException;
import org.grupin.repo.RepoAgendamentos;

import java.util.ArrayList;


/** Classe para controle de dados de Agendamento.
 * @author Matheus Machado
 */
public class ControleAgendamentos {

    private final RepoAgendamentos repo;


    public ControleAgendamentos() {
        this.repo = new RepoAgendamentos();
    }


    /** Metodo para registrar um agendamento no repositorio
     * @param agendamento Agendamento - Agendamento a ser adicionado ao repositorio
     * @throws ArquivoNaoEscitoException -
     * @throws AgendamentoInvalidoPorId
     */
    public void addAgendamento(Agendamento agendamento)  throws ArquivoNaoEscitoException, AgendamentoInvalidoPorId {


        if(this.pegarAgendamento(agendamento.getIdAgendamento()) != null) {
            throw new AgendamentoInvalidoPorId();
        } else {
            try {
                this.repo.adicionar(agendamento);
            } catch (Exception excep) {
                throw new ArquivoNaoEscitoException();
            }

        }



    }


    /** Metodo para mudar tag (status) do servico agendado
     * @param idAgendamento
     * @param novaTag
     * @return Agendamento -
     * @throws ArquivoNaoEscitoException
     * @throws AgendamentoNaoEncontradoException
     */
    public Agendamento mudarTag(int idAgendamento, String novaTag) throws ArquivoNaoEscitoException, AgendamentoNaoEncontradoException {

        Agendamento a = null;
        try {

            this.repo.mudarTag(novaTag, idAgendamento);
            a = this.repo.buscarAgendamento(idAgendamento);

        }  catch (Exception excep) {

            throw new ArquivoNaoEscitoException();

        }

        return a;
    }


    public Agendamento pegarAgendamento(int idAgendamento) throws ArquivoNaoEscitoException {


        try {
            Agendamento a = this.repo.buscarAgendamento(idAgendamento);
            return a;
        } catch (Exception excep) {
            throw new ArquivoNaoEscitoException();
        }




    }

    public ArrayList<Agendamento> listarAgendamentos() {
        try {
            return this.repo.listar();
        } catch (Exception excep) {
            return null;
        }
    }

}
