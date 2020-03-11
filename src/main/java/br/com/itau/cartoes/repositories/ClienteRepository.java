package br.com.itau.cartoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.itau.cartoes.models.Cliente;

//public interface ClienteRepository extends JpaRepository<Cliente, Integer>
public interface ClienteRepository extends CrudRepository<Cliente, Integer>
{

}

