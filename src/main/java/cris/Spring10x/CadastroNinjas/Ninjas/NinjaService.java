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



}
