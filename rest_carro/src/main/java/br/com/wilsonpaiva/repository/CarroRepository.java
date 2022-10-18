package br.com.wilsonpaiva.repository;

import br.com.wilsonpaiva.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {



}
