package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Produto;
import org.grupin.repo.contratos.IRepoProdutos;

import java.io.*;
import java.util.ArrayList;

public class RepoProdutos implements IRepoProdutos{

    private Gson gson;
    private ArrayList<Produto> listagem;
    private PrintWriter escrivao;

    @Override
    public void adicionar(Produto produto) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.listagem.add(produto);
        this.limparArquivo();
        this.reescrever();

    }

    @Override
    public Produto remover(Produto p) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.limparArquivo();

        System.out.println(p.getReferenciaProduto());
        String a2 = p.getReferenciaProduto();
        System.out.println(this.listagem);
        for(int i = 0; i < this.listagem.size(); i++) {

            String a1 = this.listagem.get(i).getReferenciaProduto();

            if(a1.equals(a2)) {
                System.out.println("asfasf");
                this.listagem.remove(this.listagem.get(i));
                break;
            }
        }
        System.out.println(this.listagem);
        this.reescrever();
        return p;

    }


    @Override
    public ArrayList<Produto> listar() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();

        BufferedReader br;

        //Bloco try catch para criar o arquyivo caso necessario
        try {
            br = new BufferedReader(new FileReader("./jsons/produtos.json"));
            br.close();
        }catch (Exception e) {
            this.limparArquivo();
        }

        br = new BufferedReader(new FileReader("./jsons/produtos.json"));

        //Redundancias e coisa estranhas na linha abaixo graças à biblioteca gson
        this.listagem = gson.fromJson(br, new TypeToken<ArrayList<Produto>>(){}.getType());

        if(this.listagem == null) {
            this.listagem = new ArrayList<>();
        }
        return this.listagem;

    }

    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);

        this.escrivao = new PrintWriter("./jsons/produtos.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }

    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException {
        this.escrivao = new PrintWriter("./jsons/produtos.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();
    }


    public Produto acharProduto(String referencia) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();

        for(Produto p : this.listagem) {
            if(referencia.equals(p.getReferenciaProduto())) {
                return p;
            }
        }

        return null;
    }


}
