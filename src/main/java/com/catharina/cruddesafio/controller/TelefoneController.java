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
import com.catharina.cruddesafio.model.Telefone;
import com.catharina.cruddesafio.responses.Responses;
import com.catharina.cruddesafio.services.TelefoneService;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {
	
	@Autowired
	private TelefoneService telefoneService;
	
	@GetMapping
	public ResponseEntity<Responses<List<Telefone>>> listarTelefonePorCliente(Cliente cliente){
		return ResponseEntity.ok(new Responses<List<Telefone>>(this.telefoneService.listarTelefonesPorCliente(cliente)));
	}

	@PostMapping
	public ResponseEntity<Responses<Telefone>> cadastrarTelefone(@Validated @RequestBody Telefone telefone, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<>(erros));
		}
		return ResponseEntity.ok(new Responses<Telefone>(this.telefoneService.cadastrarTelefone(telefone)));		
	}
	
	@PutMapping
	public ResponseEntity<Responses<Telefone>> atualizarEmail(@Validated @RequestBody Telefone telefone, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<>(erros));
		}
		return ResponseEntity.ok(new Responses<Telefone>(this.telefoneService.atualizarTelefone(telefone)));		
	}
	
	@DeleteMapping
	public ResponseEntity<Responses<Integer>> remover(Telefone telefone){
		this.telefoneService.removerTelefone(telefone);
		return ResponseEntity.ok(new Responses<Integer>(1));
	}

}
