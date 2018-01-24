package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Venda;
import org.grupin.repo.contratos.IRepoVendas;

import java.io.*;
import java.util.ArrayList;

public class RepoVendas implements IRepoVendas{

    private Gson gson;
    private ArrayList<Venda> listagem;
    private PrintWriter escrivao;

    @Override
    public void adicionar(Venda venda) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.listagem.add(venda);
        this.reescrever();

    }

    @Override
    public ArrayList<Venda> listar() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();

        BufferedReader br;


        //Bloco try catch para criar o arquyivo caso necessario
        try {
            br = new BufferedReader(new FileReader("./jsons/vendas.json"));
            br.close();
        }catch (Exception excep) {
            this.limparArquivo();
        }

        br = new BufferedReader(new FileReader("./jsons/vendas.json"));

        //Redundancias e coisa estranhas na linha abaixo graças à biblioteca gson

        JsonArray jsonArray = new JsonArray();



        this.listagem = gson.fromJson(br, new TypeToken<ArrayList<Venda>>(){}.getType());

        if(this.listagem == null) {
            this.listagem = new ArrayList<>();
        }

        return this.listagem;

    }

    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);
        this.escrivao = new PrintWriter("./jsons/vendas.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }

    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException{

        this.escrivao = new PrintWriter("./jsons/vendas.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();

    }

    @Override
    public Venda pegarVenda(int idVenda) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();

        for(Venda v : this.listagem) {
            if(v.getNumVenda() ==  idVenda) {
                return v;
            }
        }
        return null;

    }
}