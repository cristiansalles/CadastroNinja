package cris.Spring10x.CadastroNinjas;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro_de_ninjas")

public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String nome;
    private String emaol;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String emaol, int idade) {
        this.nome = nome;
        this.emaol = emaol;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmaol() {
        return emaol;
    }

    public void setEmaol(String emaol) {
        this.emaol = emaol;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
