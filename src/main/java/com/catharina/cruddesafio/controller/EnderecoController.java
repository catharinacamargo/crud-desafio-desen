package com.catharina.cruddesafio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Endereco;
import com.catharina.cruddesafio.responses.Responses;
import com.catharina.cruddesafio.services.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping(path="/{cpf}")
	public ResponseEntity<Responses<List<Endereco>>> listarEnderecoPorCpf(Cliente cliente){
		return ResponseEntity.ok(new Responses<List<Endereco>>(this.enderecoService.listarEnderecosPorCliente(cliente)));
	}

	@PostMapping
	public ResponseEntity<Responses<Endereco>> cadastrarEndereco(@Validated @RequestBody Endereco endereco, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<>(erros));
		}
		return ResponseEntity.ok(new Responses<Endereco>(this.enderecoService.cadastrarEndereco(endereco)));		
	}
	
	@PutMapping
	public ResponseEntity<Responses<Endereco>> atualizarEndereco(@Validated @RequestBody Endereco endereco, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<>(erros));
		}
		return ResponseEntity.ok(new Responses<Endereco>(this.enderecoService.atualizarEndereco(endereco)));		
	}
	
	@DeleteMapping
	public ResponseEntity<Responses<Integer>> remover(Endereco endereco){
		this.enderecoService.removerEndereco(endereco);
		return ResponseEntity.ok(new Responses<Integer>(1));
	}

}
