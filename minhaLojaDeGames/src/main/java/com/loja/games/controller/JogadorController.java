package com.loja.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.games.model.Jogador;
import com.loja.games.repository.JogadorRepository;


@RestController
@RequestMapping("/jogador")
@CrossOrigin("*")
public class JogadorController {
	
	@Autowired
	private JogadorRepository repository;
	
	@GetMapping
	private ResponseEntity<List<Jogador>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogador> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Jogador>> getByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(nome));
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Jogador> post(@RequestBody Jogador jogador){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogador));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Jogador> put(@RequestBody Jogador jogador){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(jogador));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
		repository.deleteById(id);
	}
}