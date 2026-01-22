package cris.Spring10x.CadastroNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cris.Spring10x.CadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MissoesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeMissao;
    private String hanck;
    //TODO: Uma missão pode ter varios ninjas.
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore //TODO: interrompe serialização(para o lupe).
    private List<NinjaModel> ninja;

}