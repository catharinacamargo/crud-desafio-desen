package com.catharina.cruddesafio.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.repositories.ClienteRepository;
import com.catharina.cruddesafio.services.ClienteService;

@Service
public class ClienteImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarTodosClientes() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listarPorCpf(String cpf) {
		return this.clienteRepository.findByCpf(cpf);
	}

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public void RemoverCliente(Integer id) {
		this.clienteRepository.deleteById(id);
		
	}

	@Override
	public Cliente atualizarCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente listarClientePorId(Integer id) {
		return this.clienteRepository.getOne(id);
	}

}
