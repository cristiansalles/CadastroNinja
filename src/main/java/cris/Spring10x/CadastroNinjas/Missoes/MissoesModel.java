package cris.Spring10x.CadastroNinjas.Missoes;

import cris.Spring10x.CadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor

public class MissoesModel {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeMissao;
    private String hanck;
    //TODO: Uma missão pode ter varios ninjas.
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;

}