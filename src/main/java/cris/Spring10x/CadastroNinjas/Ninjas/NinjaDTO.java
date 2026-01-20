package cris.Spring10x.CadastroNinjas.Ninjas;

import cris.Spring10x.CadastroNinjas.Missoes.MissoesModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private MissoesModel missoes;

}
