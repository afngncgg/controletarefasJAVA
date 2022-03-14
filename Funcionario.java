package controle;

import java.util.ArrayList;

/**
 * @author afonso gonczoroski
 * data 14-03-2022
 */

public class Funcionario {
    private int Matricula;
    private String Nome;
    private Departamento Departamento;
    
    public Funcionario() {
    }

    public Funcionario(int Matricula, String Nome) {
        this.Matricula = Matricula;
        this.Nome = Nome;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Departamento getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.Departamento = departamento;
    }
    
    
    
}
