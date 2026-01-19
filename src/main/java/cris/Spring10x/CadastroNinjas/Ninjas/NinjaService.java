package cris.Spring10x.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class NinjaService {
    //TODO: instanciar repositorio.
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //TODO: Listar ninjas.
    public List<NinjaModel> listarNinjas()  {
        return ninjaRepository.findAll();
    }

    //TODO: listar todos por ID.
    public NinjaModel listarNinjasPorId(long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    //TODO: Criar novo ninja.
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //TODO: Deletar Ninjas.
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    //TODO: Alterar Cadastro.
    public NinjaModel alterarNinja (Long id, NinjaModel ninjaAlterado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAlterado.setId(id);
            return ninjaRepository.save(ninjaAlterado);
        }
        return null;

    }



}
