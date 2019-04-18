package com.catharina.cruddesafio.services;

import java.util.List;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Endereco;

public interface EnderecoService {

	List<Endereco> listarEnderecosPorCliente(Cliente cliente);
	Endereco cadastrarEndereco(Endereco endereco);
	void removerEndereco(Endereco endereco);
	Endereco atualizarEndereco(Endereco endereco);

}
