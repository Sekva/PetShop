package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Agendamento;
import org.grupin.exceptions.AgendamentoNaoEncontradoException;
import org.grupin.repo.contratos.IRepoAgendamentos;

import java.io.*;
import java.util.ArrayList;

public class RepoAgendamentos implements IRepoAgendamentos {


    private Gson gson;

    private ArrayList<Agendamento> listagem;
    private PrintWriter escrivao;

    @Override
    public void adicionar(Agendamento agendamento) throws FileNotFoundException, UnsupportedEncodingException {
        this.listagem = this.listar();
        this.listagem.add(agendamento);
        this.reescrever();

    }

    @Override
    public void mudarTag(String novaTag , int idAgendamento) throws FileNotFoundException, UnsupportedEncodingException, AgendamentoNaoEncontradoException {

        this.listagem = this.listar();
        this.limparArquivo();

        boolean foiAchado = false;



        for(int i = 0; i < this.listagem.size(); i++) {

            if(this.listagem.get(i).getIdAgendamento() == idAgendamento) {
                this.listagem.get(i).setTag(novaTag);
                foiAchado = true;
            }

        }

        if(!foiAchado) {
            this.reescrever();
            throw new AgendamentoNaoEncontradoException(idAgendamento);
        }

        this.reescrever();

    }

    @Override
    public ArrayList<Agendamento> listar() throws FileNotFoundException, UnsupportedEncodingException{

        this.gson = new Gson();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("./jsons/agendamentos.json"));
            br.close();
        }catch (Exception e) {
            this.limparArquivo();
        }

        br = new BufferedReader(new FileReader("./jsons/agendamentos.json"));
        //Redundancias e coisa estranhas na linha abaixo graças à biblioteca gson
        this.listagem = gson.fromJson(br, new TypeToken<ArrayList<Agendamento>>(){}.getType());

        if(this.listagem == null) {
            this.listagem = new ArrayList<>();
        }

        return this.listagem;
    }


    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);
        this.escrivao = new PrintWriter("./jsons/agendamentos.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }

    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException {

        this.escrivao = new PrintWriter("./jsons/agendamentos.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();

    }

    @Override
    public Agendamento buscarAgendamento(int idAgendamento) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();

        for(Agendamento a : this.listagem) {
            if(a.getIdAgendamento() == idAgendamento) {
                return a;
            }
        }

        return null;
    }

}
