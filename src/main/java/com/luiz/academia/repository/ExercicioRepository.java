package com.luiz.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.academia.entity.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{

}
