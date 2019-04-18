package com.catharina.cruddesafio.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Email;
import com.catharina.cruddesafio.repositories.EmailRepository;
import com.catharina.cruddesafio.services.EmailService;

@Service
public class EmailImpl implements EmailService {
	
	@Autowired
	EmailRepository emailRepository;

	@Override
	public Email cadastrarEmail(Email email) {
		return this.emailRepository.save(email);
	}

	@Override
	public void removerEmail(Email email) {
		this.emailRepository.delete(email);
	}

	@Override
	public Email atualizarEmail(Email email) {
		return this.emailRepository.save(email);
	}

	@Override
	public List<Email> listarEmailPorCliente(Cliente cliente) {
		return this.emailRepository.findEmailByCliente(cliente);
	}

	@Override
	public List<Email> listarTodosEmails() {
		return this.emailRepository.findAll();
	}

}
