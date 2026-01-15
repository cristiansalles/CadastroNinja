package cris.Spring10x.CadastroNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")

public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Primeira menssagem";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    @GetMapping("/lista")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/lista/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    @PutMapping("/alterar")
    public String alterarNinjaPorId() {
        return "Alterar Ninjas Por Id";
    }

    @DeleteMapping("/deletarId")
    public String deletarNinjaId() {
        return "Deletar Ninja Por Id";
    }

}
