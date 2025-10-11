package cris.Spring10x.CadastroNinjas.Ninjas;

import cris.Spring10x.CadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

//TODO: transforma uma classe em entidade (tabela)
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Getter
    @Setter
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

}
