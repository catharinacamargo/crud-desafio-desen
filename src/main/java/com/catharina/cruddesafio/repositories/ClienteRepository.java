package com.catharina.cruddesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catharina.cruddesafio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findByCpf(String cpf);

}
