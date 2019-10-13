package br.com.ivanfsilva.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ivanfsilva.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
