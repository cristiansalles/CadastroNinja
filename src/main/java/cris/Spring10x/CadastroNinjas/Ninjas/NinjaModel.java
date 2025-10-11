package cris.Spring10x.CadastroNinjas.Ninjas;

import cris.Spring10x.CadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;
//TODO: transforma uma classe em entidade (tabela)
@Entity
@Table(name = "tb_cadastro_de_ninjas")

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private int idade;
//TODO: Varios ninjas podem tem uma missão.
    @ManyToOne
    @JoinColumn(name = "tb_missoes_id")// Foreing Key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String emaol, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmaol() {
        return email;
    }

    public void setEmaol(String emaol) {
        this.email = emaol;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
