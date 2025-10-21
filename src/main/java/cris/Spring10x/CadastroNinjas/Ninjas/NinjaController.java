package cris.Spring10x.CadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")

public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Primeira menssagem";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/lista")
    public String mostrasTodosNinjas(){
        return "Todos os Ninjas";
    }

    @GetMapping("/listaId")
    public String mostrasTodosNinjasPorId(){
        return "Todos os Ninjas por Id";
    }

    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "Alterar Ninjas Por Id";
    }

    @DeleteMapping("/deletarId")
    public String deletarNinjaId(){
        return "Deletar Ninja Por Id";
    }

}
