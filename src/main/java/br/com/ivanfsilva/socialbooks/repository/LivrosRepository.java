package br.com.ivanfsilva.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ivanfsilva.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
