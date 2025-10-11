package cris.Spring10x.CadastroNinjas.Missoes;

import cris.Spring10x.CadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeMissao;
    private String hanck;
//TODO: Uma missão pode ter varios ninjas.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

    public MissoesModel() {
    }

    public MissoesModel(long id, String nome, String hanck) {
        this.id = id;
        this.nomeMissao = nome;
        this.hanck = hanck;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getHanck() {
        return hanck;
    }

    public void setHanck(String hanck) {
        this.hanck = hanck;
    }
}
