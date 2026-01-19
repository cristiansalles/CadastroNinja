package cris.Spring10x.CadastroNinjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cris.Spring10x.CadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

    //TODO: transforma uma classe em entidade (tabela)
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id")
        private long id;

        @Column(name = "Nome")
        private String nome;

        @Column(name = "Email" , unique = true)
        private String email;

        @Column(name = "Idade")
        private int idade;

    //TODO: Varios ninjas podem tem uma missão.
    @ManyToOne
    @JoinColumn(name = "tb_missoes_id")// TODO: Foreing Key ou chave estrangeira
    private MissoesModel missoes;

}
