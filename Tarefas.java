
package controle;

import java.util.ArrayList;

/**
 *
 * @author afonso gonczoroski
 * data 14-03-2022
 */

public class Tarefas {
    private int ID;
    private String nomeTitulo;
    private String nomeDescricao;
    private String nomePrazo;
    private int duracao;
    private boolean finalizado;
    private Funcionario funcionarios;

    public Tarefas(int ID, String nomeTitulo, String nomeDescricao, String nomePrazo, int duracao, boolean finalizado) {
        this.ID = ID;
        this.nomeTitulo = nomeTitulo;
        this.nomeDescricao = nomeDescricao;
        this.nomePrazo = nomePrazo;
        this.duracao = duracao;
        this.finalizado = finalizado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getnomeTitulo() {
        return nomeTitulo;
    }

    public void setnomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }
    
    public String getnomeDescricao(){
        return nomeDescricao;
    }
    
    public void setnomeDescricao(String nomeDescricao){
        this.nomeDescricao = nomeDescricao;
    }
    
    public String getnomePrazo(){
        return nomePrazo;
    }
    
    public void setnomePrazo(String nomePrazo){
        this.nomePrazo = nomePrazo;
    }
    
    public int getduracao(){
    return duracao;
}
    public void setduracao(int duracao){
        this.duracao = duracao;
    }
    
    public boolean getfinalizado(){
        return finalizado;
    }
    
    public void setfinalizado(boolean finalizado){
        this.finalizado = finalizado;
    }
    
    public Funcionario getFuncionario() {
        return funcionarios;
    }
      
    public void setTarefas(Funcionario funcionarios) {
        this.funcionarios = funcionarios;
    }
}
