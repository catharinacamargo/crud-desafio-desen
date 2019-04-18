package com.catharina.cruddesafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catharina.cruddesafio.model.Cliente;
import com.catharina.cruddesafio.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	List<Endereco> findByCliente(Cliente cliente);

}
