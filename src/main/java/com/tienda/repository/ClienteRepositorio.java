package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

}
