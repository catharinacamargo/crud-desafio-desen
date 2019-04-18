package com.catharina.cruddesafio.services;

import java.util.List;

import com.catharina.cruddesafio.model.Cliente;

public interface ClienteService {
	
	List<Cliente> listarTodosClientes();
	Cliente listarPorCpf(String cpf);
	Cliente cadastrarCliente(Cliente cliente);
	void RemoverCliente(Integer id);
	Cliente atualizarCliente(Cliente cliente);
	Cliente listarClientePorId(Integer id);
	

}
