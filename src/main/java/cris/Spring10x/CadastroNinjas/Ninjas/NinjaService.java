package cris.Spring10x.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class NinjaService {
    //instanciar repositorio.
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar ninjas.
    public List<NinjaModel> listarNinjas()  {
        return ninjaRepository.findAll();
    }

    //listar todos por ID.
    public NinjaModel listarNinjasPorId(long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //Criar novo ninja.
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //Deletar Ninjas.
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Alterar Cadastro.
    public NinjaModel alterarNinja (Long id, NinjaModel ninjaAlterado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAlterado.setId(id);
            return ninjaRepository.save(ninjaAlterado);
        }
        return null;

    }



}
