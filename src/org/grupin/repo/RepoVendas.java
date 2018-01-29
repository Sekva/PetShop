package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Venda;
import org.grupin.repo.contratos.IRepoVendas;

import java.io.*;
import java.util.ArrayList;

/** Classe para uso de armazenamento de vendas na pasta ./jsons
 * @author Matheus Machado Vieira
 * @see org.grupin.repo.contratos.IRepoVendas para
 * mais informações sobre o contrato para reimplementar a forma de armazenamento
 * persistente.
 *
 */

public class RepoVendas implements IRepoVendas{

    private Gson gson;
    private ArrayList<Venda> listagem;
    private PrintWriter escrivao;


    /**
     * Recria o array list de vendas do arquivo vendas.json
     * adiciona a nova venda e reescreve o arquivo.
     * @param venda venda a ser adicionada
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    @Override
    public void adicionar(Venda venda) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.listagem.add(venda);
        this.reescrever();

    }

    /**
     * Metodos que recria o arraylist de vendas a partir do arquivo
     * vendas.json para uso interno e externo
     * @return a arraylist com todas as vendas {@code ArrayList<Venda>}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
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
    /**
     * Metodo que reescreve a arraylist de agendamentos no arquivo vendas.json
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);
        this.escrivao = new PrintWriter("./jsons/vendas.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }


    /**
     * Metodo para limpeza do arquivo de vendas por segurança,
     * caso houver alguma informação legada no buffer
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException{

        this.escrivao = new PrintWriter("./jsons/vendas.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();

    }

    /**
     * Metodo de busca para vendas. Usa o indentificador
     * para encontrar dada venda e retornar
     * @param idVenda indentificador da Venda
     * @return retorna uma unica {@code Venda}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
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