package com.luiz.academia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.academia.entity.Exercicio;
import com.luiz.academia.repository.ExercicioRepository;

@Service
public class ExercicioService {

	private final ExercicioRepository repo;

	@Autowired
	public ExercicioService(ExercicioRepository repositorio) {
		this.repo = repositorio;
	}

	public List<Exercicio> findAll() {
		return repo.findAll();
	}

	public Exercicio save(Exercicio exercicio) {
		return repo.save(exercicio);
	}

	public Exercicio update(Long id, Exercicio exercicioAtualizado) {
		Optional<Exercicio> exercicioExistente = repo.findById(id);
		if (exercicioExistente.isPresent()) {
			Exercicio exercicio = exercicioExistente.get();
			exercicio.setNome(exercicioAtualizado.getNome() != null ? exercicioAtualizado.getNome()
					: exercicioExistente.get().getNome());
			exercicio.setCarga(exercicioAtualizado.getCarga() != null ? exercicioAtualizado.getCarga()
					: exercicioExistente.get().getCarga());
			exercicio.setRepeticao(exercicioAtualizado.getRepeticao() != null ? exercicioAtualizado.getRepeticao()
					: exercicioExistente.get().getRepeticao());
			exercicio.setSerie(exercicioAtualizado.getSerie() != null ? exercicioAtualizado.getSerie()
					: exercicioExistente.get().getSerie());
			return repo.save(exercicio);

		} else {
			throw new RuntimeException("Exercicio não encontrado com o ID: " + id);
		}
	}
	
	public void delete(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
		else {
			throw new RuntimeException("Exercicio não encontrado com o ID: " + id);
		}
	}
	
}
