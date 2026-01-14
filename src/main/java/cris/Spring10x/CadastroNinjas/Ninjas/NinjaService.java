package cris.Spring10x.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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



}
