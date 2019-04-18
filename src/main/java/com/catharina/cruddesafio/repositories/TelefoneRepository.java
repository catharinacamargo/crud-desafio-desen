package com.catharina.cruddesafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

	List<Telefone> findTelefoneByCliente(Cliente cliente);

}
