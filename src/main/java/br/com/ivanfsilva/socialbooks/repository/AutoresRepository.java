package br.com.ivanfsilva.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ivanfsilva.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
