package com.catharina.cruddesafio.services;

import java.util.List;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Telefone;

public interface TelefoneService {
	
	Telefone cadastrarTelefone(Telefone telefone);
	void removerTelefone(Telefone telefone);
	Telefone atualizarTelefone(Telefone telefone);
	List<Telefone> listarTelefonesPorCliente(Cliente cliente);

}
