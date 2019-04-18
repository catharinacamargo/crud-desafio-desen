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
import com.catharina.cruddesafio.model.Email;
import com.catharina.cruddesafio.responses.Responses;
import com.catharina.cruddesafio.services.ClienteService;
import com.catharina.cruddesafio.services.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Responses<List<Email>>> listarTodos(){
		return ResponseEntity.ok(new Responses<List<Email>>(this.emailService.listarTodosEmails()));
	}
	
//	@GetMapping
//	public ResponseEntity<Responses<List<Email>>> listarEmailPorCliente(Cliente cliente){
//		return ResponseEntity.ok(new Responses<List<Email>>(this.emailService.listarEmailPorCliente(cliente)));
//	}

	@PostMapping(path="/{fk_cliente}")
	public ResponseEntity<Responses<Email>> cadastrarEmail(@PathVariable(name="fk_cliente") Integer fk_cliente, @Validated @RequestBody Email email, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<>(erros));
		}
		email.setCliente(this.clienteService.listarClientePorId(fk_cliente));
		return ResponseEntity.ok(new Responses<Email>(this.emailService.cadastrarEmail(email)));		
	}
	
	@PutMapping
	public ResponseEntity<Responses<Email>> atualizarEmail(@Validated @RequestBody Email email, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<>(erros));
		}
		return ResponseEntity.ok(new Responses<Email>(this.emailService.atualizarEmail(email)));		
	}
	
	@DeleteMapping
	public ResponseEntity<Responses<Integer>> remover(Email email){
		this.emailService.removerEmail(email);
		return ResponseEntity.ok(new Responses<Integer>(1));
	}

}
