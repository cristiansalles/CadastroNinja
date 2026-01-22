package cris.Spring10x.CadastroNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")

public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @PostMapping("/criar")
    public ResponseEntity<NinjaDTO> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<NinjaDTO> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaId = ninjaService.listarNinjasPorId(id);
        if (ninjaId == null) {
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(ninjaId);

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<NinjaDTO> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAlterado) {
       NinjaDTO atualizado = ninjaService.alterarNinja(id, ninjaAlterado);
       if (atualizado == null) {
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarNinjaId(@PathVariable Long id) {
      boolean deletado = ninjaService.deletarNinja(id);

      if(!deletado){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.noContent().build();
    }

}
