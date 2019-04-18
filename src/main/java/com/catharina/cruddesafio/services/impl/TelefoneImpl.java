package com.catharina.cruddesafio.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Telefone;
import com.catharina.cruddesafio.repositories.TelefoneRepository;
import com.catharina.cruddesafio.services.TelefoneService;

@Service
public class TelefoneImpl implements TelefoneService {
	
	private TelefoneRepository telefoneRepository;

	@Override
	public Telefone cadastrarTelefone(Telefone telefone) {
		return this.telefoneRepository.save(telefone);
	}

	@Override
	public void removerTelefone(Telefone telefone) {
		this.telefoneRepository.delete(telefone);
	}

	@Override
	public Telefone atualizarTelefone(Telefone telefone) {
		return this.telefoneRepository.save(telefone);
	}

	@Override
	public List<Telefone> listarTelefonesPorCliente(Cliente cliente) {
		return this.telefoneRepository.findTelefoneByCliente(cliente);
	}

}
