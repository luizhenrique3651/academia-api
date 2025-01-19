package com.luiz.academia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "exercicio", schema = "academia")
public class Exercicio {

	@Id
	@Column(name = "cod_exercicio")
	Long id;
	
	@Column(name = "nom_exercicio")
	String nome;
	
	@Column(name = "num_repeticao")
	Integer repeticao;
	
	@Column(name = "num_serie")
	Integer serie;
	
	@Column(name = "carga")
	Double carga;
	
	
}
