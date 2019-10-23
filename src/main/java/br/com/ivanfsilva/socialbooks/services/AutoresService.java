package br.com.ivanfsilva.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ivanfsilva.socialbooks.domain.Autor;
import br.com.ivanfsilva.socialbooks.repository.AutoresRepository;
import br.com.ivanfsilva.socialbooks.services.exceptions.AutorExistenteException;
import br.com.ivanfsilva.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {

	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Optional<Autor> a = autoresRepository.findById(autor.getId());
			
			if(a.isPresent()) {				
				throw new AutorExistenteException("O autor já existe");				
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Optional<Autor> autor = autoresRepository.findById(id);
		
		if(!autor.isPresent()) {				
			throw new AutorNaoEncontradoException("O autor não pôde ser encontrado");				
		}	
		
		return autor.get();
	}
}
