package com.loja.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.games.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{
	public List<Jogador> findAllByTituloContainingIgnoreCase (String nome);
}
