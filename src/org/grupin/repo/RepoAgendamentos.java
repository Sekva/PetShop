package org.grupin.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.grupin.entidades.Agendamento;
import org.grupin.exceptions.AgendamentoNaoEncontradoException;
import org.grupin.repo.contratos.IRepoAgendamentos;

import java.io.*;
import java.util.ArrayList;


/** Classe para uso de armazenamento de agendamentos na pasta ./jsons
 * @author Matheus Machado Vieira
 * @see org.grupin.repo.contratos.IRepoAgendamentos para
 * mais informações sobre o contrato para reimplementar a forma de armazenamento
 * persistente.
 *
 */

public class RepoAgendamentos implements IRepoAgendamentos {


    private Gson gson;
    private ArrayList<Agendamento> listagem;
    private PrintWriter escrivao;


    /**
     * Recria o array list de agendamentos do arquivo agendamentos.json
     * adiciona o novo agendamento e reescreve o arquivo.
     * @param agendamento agendamento a ser adicionado
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */

    @Override
    public void adicionar(Agendamento agendamento) throws FileNotFoundException, UnsupportedEncodingException {
        this.listagem = this.listar();
        this.listagem.add(agendamento);
        this.reescrever();

    }


    /**
     * Metodo para mudar o estado de um agendamento, recria o arraylist da memoria,
     * busca o agendamento a partir do indentificador,
     * altera o estado do agendamento e reescreve no arquivo
     * @param novaTag novo estado do agendamento
     * @param idAgendamento numero identificador do agendamento
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     * @throws AgendamentoNaoEncontradoException Caso agendamento não seja encontrado
     * @see org.grupin.entidades.Agendamento
     */
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


    /**
     * Metodos que recria o arraylist de agendamentos a partir do arquivo
     * agendamentos.json para uso interno e externo
     * @return a arraylist com todos os agendamentos {@code ArrayList<Agendamento>}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    @Override
    public ArrayList<Agendamento> listar() throws FileNotFoundException, UnsupportedEncodingException{

        this.gson = new Gson();
        BufferedReader br;
        try {
            System.out.println("aqui 4");

            br = new BufferedReader(new FileReader("./jsons/agendamentos.json"));
            br.close();
        }catch (Exception excep) {
            System.out.println("aqui 5");

            this.limparArquivo();
        }

        br = new BufferedReader(new FileReader("./jsons/agendamentos.json"));
        System.out.println("aqui 6");

        //Redundancias e coisa estranhas na linha abaixo graças à biblioteca gson

        //LINHA ABAIXO NAO FUNCIONA NO JAR
        this.listagem = gson.fromJson(br, new TypeToken<ArrayList<Agendamento>>(){}.getType());
        System.out.println("aqui 7");

        if(this.listagem == null) {
            System.out.println("aqui 8");

            this.listagem = new ArrayList<>();
        }

        System.out.println("aqui 9");

        return this.listagem;
    }


    /**
     * Metodo que reescreve a arraylist de agendamentos no arquivo agendamentos.json
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    private void reescrever() throws FileNotFoundException, UnsupportedEncodingException {

        this.gson = new Gson();
        String jsonTipo = this.gson.toJson(this.listagem);
        this.escrivao = new PrintWriter("./jsons/agendamentos.json", "UTF-8");
        this.escrivao.write(jsonTipo);
        this.escrivao.close();

    }


    /**
     * Metodo para limpeza do arquivo de agendamentos por segurança,
     * caso houver alguma informação legada no buffer
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
    private void limparArquivo() throws FileNotFoundException, UnsupportedEncodingException {

        this.escrivao = new PrintWriter("./jsons/agendamentos.json", "UTF-8");
        this.escrivao.write("");
        this.escrivao.close();

    }

    /**
     * Metodo de busca para agendamentos. Usa o indentificador
     * para encontrar dado agendamento e retornar
     * @param idAgendamento indentificador do agendamento
     * @return retorna um unico {@code Agendamento}
     * @throws FileNotFoundException Arquivo nao encontrado
     * @throws UnsupportedEncodingException Encoding nao suportado para o arquivo no SO em uso
     */
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
