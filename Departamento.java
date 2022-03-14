package controle;

import java.util.ArrayList;

/**
 * @author afonso gonczoroski
 */

public class Departamento {
    private int Codigo;
    private String Nome;
    ArrayList<Funcionario> ListaFuncionario;

    public Departamento() {
        ListaFuncionario = new ArrayList();
    }

    public Departamento(int Codigo, String Nome) {
        this.Codigo = Codigo;
        this.Nome = Nome;
        ListaFuncionario = new ArrayList();
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public ArrayList<Funcionario> getListaFuncionario() {
        return ListaFuncionario;
    }

    public void setListaFuncionario(ArrayList<Funcionario> ListaFuncionario) {
        this.ListaFuncionario = ListaFuncionario;
    }
    
    public void addFuncionario(Funcionario F){
        F.setDepartamento(this);
        ListaFuncionario.add(F);
    }
}
