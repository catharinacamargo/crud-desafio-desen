package com.catharina.cruddesafio.services;

import java.util.List;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Email;

public interface EmailService {
	
	Email cadastrarEmail(Email email);
	void removerEmail(Email email);
	Email atualizarEmail(Email email);
	List<Email> listarEmailPorCliente(Cliente cliente);
	List<Email> listarTodosEmails();

}
