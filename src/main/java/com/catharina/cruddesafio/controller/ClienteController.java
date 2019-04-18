package com.catharina.cruddesafio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.responses.Responses;
import com.catharina.cruddesafio.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Responses<List<Cliente>>> listarTodos(){
		return ResponseEntity.ok(new Responses<List<Cliente>>(this.clienteService.listarTodosClientes()));
	}
	
	@GetMapping(path="/buscaPorCpf/{cpf}")
	public ResponseEntity<Responses<Cliente>> listarPorCpf(@PathVariable(name ="cpf") String cpf){
		return ResponseEntity.ok(new Responses<Cliente>(this.clienteService.listarPorCpf(cpf)));
	}

	
	@GetMapping(path="/buscaPorId/{id}")
	public ResponseEntity<Responses<Cliente>> listarPorId(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(new Responses<Cliente>(this.clienteService.listarClientePorId(id)));
	}
	
	@PostMapping(path="/cadastrarCliente")
	public ResponseEntity<Responses<Cliente>> cadastrar(@Validated @RequestBody Cliente cliente, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<>(erros));
		}
		return ResponseEntity.ok(new Responses<Cliente>(this.clienteService.cadastrarCliente(cliente)));		
	}
	
	@PutMapping(path="/atualizarCliente/{cpf}")
	public ResponseEntity<Responses<Cliente>> atualizar(@PathVariable(name="cpf") String cpf, @RequestBody Cliente cliente){
		cliente.setCpf(cpf);
		return ResponseEntity.ok(new Responses<Cliente>(this.clienteService.atualizarCliente(cliente)));
		
	}
	
	
	@DeleteMapping(path="/excluirCliente/{id}")
	public ResponseEntity<Responses<Integer>> remover(@PathVariable(name="id") Integer id){
		this.clienteService.RemoverCliente(id);
		return ResponseEntity.ok(new Responses<Integer>(1));
	}

}
