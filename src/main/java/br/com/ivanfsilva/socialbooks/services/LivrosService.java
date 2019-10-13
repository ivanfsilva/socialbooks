package br.com.ivanfsilva.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ivanfsilva.socialbooks.domain.Livro;
import br.com.ivanfsilva.socialbooks.repository.LivrosRepository;
import br.com.ivanfsilva.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = this.livrosRepository.findById(id).orElse(null);
		
		if(livro == null) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
		
		return livro;
		
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
		}
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
}
