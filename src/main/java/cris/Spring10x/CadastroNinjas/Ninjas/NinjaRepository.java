package cris.Spring10x.CadastroNinjas.Ninjas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

}
