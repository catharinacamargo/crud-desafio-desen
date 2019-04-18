package com.catharina.cruddesafio.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Endereco;
import com.catharina.cruddesafio.repositories.EnderecoRepository;
import com.catharina.cruddesafio.services.EnderecoService;

@Service
public class EnderecoImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Endereco cadastrarEndereco(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}

	@Override
	public void removerEndereco(Endereco endereco) {
		this.enderecoRepository.delete(endereco);
	}

	@Override
	public Endereco atualizarEndereco(Endereco endereco) {
		return this.enderecoRepository.save(endereco);
	}

	@Override
	public List<Endereco> listarEnderecosPorCliente(Cliente cliente) {
		return this.enderecoRepository.findByCliente(cliente);
	}



}
