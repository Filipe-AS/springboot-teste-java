package com.filme.repository;

import org.springframework.data.repository.CrudRepository;

import com.filme.model.Filme;

public interface FilmeRepository extends CrudRepository<Filme, String> {
	
	Filme findByCodigo(long codigo);

}
