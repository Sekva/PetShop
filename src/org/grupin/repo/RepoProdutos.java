package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Produto;
import org.grupin.exceptions.AgendamentoNaoEncontradoException;
import org.grupin.repo.contratos.IRepoProdutos;

import java.io.*;
import java.util.ArrayList;

/** Classe para uso de armazenamento de produtos na pasta ./jsons
 * @author Matheus Machado Vieira
 * @see org.grupin.repo.contratos.IRepoProdutos para
 * mais informações sobre o contrato para reimplementar a forma de armazenamento
 * persistente.
 *
 */


public class RepoProdutos implements IRepoProdutos{

    private Gson gson;
    private ArrayList<Produto> listagem;
    private PrintWriter escrivao;


    /**
     * Recria o array list de agendamentos do arquivo produtos.json
     * adiciona o novo produto e reescreve o arquivo.
     * @param produto produto a ser adicionado
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    @Override
    public void adicionar(Produto produto) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.listagem.add(produto);
        this.limparArquivo();
        this.reescrever();

    }


    /**
     * Metodo pararemoção do objeto de produto p do arquivo de produtos
     * @param p produto a ser removido
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     * @see org.grupin.entidades.Produto
     */
    @Override
    public Produto remover(Produto p) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.limparArquivo();

        //IGNORE System.out.println(p.getReferenciaProduto());
        String a2 = p.getReferenciaProduto();
        //IGNORE System.out.println(this.listagem);
        for(int i = 0; i < this.listagem.size(); i++) {

            String a1 = this.listagem.get(i).getReferenciaProduto();

            if(a1.equals(a2)) {
                //IGNORE System.out.println("asfasf");
                this.listagem.remove(this.listagem.get(i));
                break;
            }
        }
        //IGNORE System.out.println(this.listagem);
        this.reescrever();
        return p;

    }

    /**
     * Metodos que recria o arraylist de produto a partir do arquivo
     * produtos.json para uso interno e externo
     * @return a arraylist com todos os produtos {@code ArrayList<Produto>}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    @Override
    public ArrayList<Produto> listar() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();

        BufferedReader br;

        //Bloco try catch para criar o arquyivo caso necessario
        try {
            br = new BufferedReader(new FileReader("./jsons/produtos.json"));
            br.close();
        }catch (Exception excep) {
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

    /**
     * Metodo que reescreve a arraylist de produtos no arquivo produtos.json
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */

    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);

        this.escrivao = new PrintWriter("./jsons/produtos.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }


    /**
     * Metodo para limpeza do arquivo de produtos por segurança,
     * caso houver alguma informação legada no buffer
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException {
        this.escrivao = new PrintWriter("./jsons/produtos.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();
    }


    /**
     * Metodo de busca para produtos. Usa o indentificador
     * para encontrar dado produto e retornar
     * @param referencia indentificador do produto
     * @return retorna um unico {@code Produto}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    @Override
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
