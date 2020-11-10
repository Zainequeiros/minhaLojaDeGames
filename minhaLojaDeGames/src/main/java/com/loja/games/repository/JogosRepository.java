package com.loja.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.games.model.Jogos;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Long> {
	
	public List<Jogos> findAllByTituloContainingIgnoreCase (String titulo);
}