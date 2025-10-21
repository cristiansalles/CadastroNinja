package cris.Spring10x.CadastroNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissao(){
        return "Criar Missão";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Alterar Missão";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Deletar Missão";
    }

    @GetMapping("/listar")
    public String listarMissao(){
        return "Listar Missão";
    }

}
