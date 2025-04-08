package br.com.lgfas.poketreinador.repository;

import br.com.lgfas.poketreinador.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Long> {
}
