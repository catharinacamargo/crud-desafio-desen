package com.catharina.cruddesafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

	List<Email> findEmailByCliente(Cliente cliente);

}
