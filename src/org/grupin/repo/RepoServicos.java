package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Produto;
import org.grupin.entidades.Servico;
import org.grupin.repo.contratos.IRepoServicos;

import java.io.*;
import java.util.ArrayList;

public class RepoServicos implements IRepoServicos {


    private Gson gson;
    private ArrayList<Servico> listagem;
    private PrintWriter escrivao;

    @Override
    public void adicionar(Servico servico) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.listagem.add(servico);
        this.limparArquivo();
        this.reescrever();

    }

    @Override
    public Servico remover(Servico p) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.limparArquivo();

        //System.out.println(p.getReferenciaProduto());
        String a2 = p.getReferenciaProduto();
        //System.out.println(this.listagem);
        for(int i = 0; i < this.listagem.size(); i++) {

            String a1 = this.listagem.get(i).getReferenciaProduto();

            if(a1.equals(a2)) {
                this.listagem.remove(this.listagem.get(i));
                break;
            }
        }
        //System.out.println(this.listagem);
        this.reescrever();
        return p;

    }

    @Override
    public ArrayList<Servico> listar() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();

        BufferedReader br;

        //Bloco try catch para criar o arquyivo caso necessario
        try {
            br = new BufferedReader(new FileReader("./jsons/servicos.json"));
            br.close();
        }catch (Exception e) {
            this.limparArquivo();
        }

        br = new BufferedReader(new FileReader("./jsons/servicos.json"));

        //Redundancias e coisa estranhas na linha abaixo graças à biblioteca gson
        this.listagem = gson.fromJson(br, new TypeToken<ArrayList<Servico>>(){}.getType());

        if(this.listagem == null) {
            this.listagem = new ArrayList<>();
        }
        return this.listagem;

    }

    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);

        this.escrivao = new PrintWriter("./jsons/servicos.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }

    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException {
        this.escrivao = new PrintWriter("./jsons/servicos.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();
    }

    @Override
    public Servico acharServico(String referencia) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();

        for(Servico p : this.listagem) {
            if(referencia.equals(p.getReferenciaProduto())) {
                return p;
            }
        }

        return null;
    }


}
