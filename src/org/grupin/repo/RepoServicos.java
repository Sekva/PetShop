package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Servico;
import org.grupin.repo.contratos.IRepoServicos;

import java.io.*;
import java.util.ArrayList;

/** Classe para uso de armazenamento de serviços na pasta ./jsons
 * @author Matheus Machado Vieira
 * @see org.grupin.repo.contratos.IRepoServicos para
 * mais informações sobre o contrato para reimplementar a forma de armazenamento
 * persistente.
 *
 */


public class RepoServicos implements IRepoServicos {


    private Gson gson;
    private ArrayList<Servico> listagem;
    private PrintWriter escrivao;


    /**
     * Recria o array list de agendamentos do arquivo servicos.json
     * adiciona o novo servico e reescreve o arquivo.
     * @param servico servico a ser adicionado
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    @Override
    public void adicionar(Servico servico) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.listagem.add(servico);
        this.limparArquivo();
        this.reescrever();

    }


    /**
     * Metodo pararemoção do objeto de Servico p do arquivo de Servicos
     * @param s Servico a ser removido
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     * @see org.grupin.entidades.Produto
     */
    @Override
    public Servico remover(Servico s) throws FileNotFoundException, UnsupportedEncodingException {

        this.listagem = this.listar();
        this.limparArquivo();

        ////IGNORE System.out.println(p.getReferenciaProduto());
        String a2 = s.getReferenciaProduto();
        ////IGNORE System.out.println(this.listagem);
        for(int i = 0; i < this.listagem.size(); i++) {

            String a1 = this.listagem.get(i).getReferenciaProduto();

            if(a1.equals(a2)) {
                this.listagem.remove(this.listagem.get(i));
                break;
            }
        }
        ////IGNORE System.out.println(this.listagem);
        this.reescrever();
        return s;

    }


    /**
     * Metodos que recria o arraylist de servicos a partir do arquivo
     * servicos.json para uso interno e externo
     * @return a arraylist com todos os servicos {@code ArrayList<Servico>}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    @Override
    public ArrayList<Servico> listar() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();

        BufferedReader br;

        //Bloco try catch para criar o arquyivo caso necessario
        try {
            br = new BufferedReader(new FileReader("./jsons/servicos.json"));
            br.close();
        }catch (Exception excep) {
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

    /**
     * Metodo que reescreve a arraylist de servicos no arquivo servicos.json
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */

    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);

        this.escrivao = new PrintWriter("./jsons/servicos.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }

    /**
     * Metodo para limpeza do arquivo de servicos por segurança,
     * caso houver alguma informação legada no buffer
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */

    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException {
        this.escrivao = new PrintWriter("./jsons/servicos.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();
    }


    /**
     * Metodo de busca para servicos. Usa o indentificador
     * para encontrar dado servico e retornar
     * @param referencia indentificador do servico
     * @return retorna um unico {@code Servico}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
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
