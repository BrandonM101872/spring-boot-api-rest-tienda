package com.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.modelo.Cliente;
import com.tienda.repository.ClienteRepositorio;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({"clientes"})
public class ClienteController {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	//tipo de metodo GET: http://localhost:7575/clientes/listar 
	@GetMapping("listar")
	public List<Cliente> listaClientes(){
		List<Cliente> clientes = (List<Cliente>) clienteRepositorio.findAll();
		return clientes;
	}
	
	//tipo de metodo GET: http://localhost:7575/clientes/{id}
	@GetMapping("/{id}")
	public Optional<Cliente> getClienteById(@PathVariable int id){
		return clienteRepositorio.findById(id);
	}
	//tipo de metodo POST: http://localhost:7575/clientes
	@PostMapping
	public Cliente agregarCliente(@RequestBody Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}
	
	//tipo de metodo PUT: http://localhost:7575/clientes/{id}
	@PutMapping("/{id}")
	public Cliente modificarCliente(@RequestBody Cliente cliente, @PathVariable int id) {
		cliente.setId(id);
		return clienteRepositorio.save(cliente);
	}
	
	//tipo de metodo DELETE: http://localhost:7575/clientes/{id}
	@DeleteMapping("/{id}")
	public void eliminarCliente(@PathVariable int id) {
		clienteRepositorio.deleteById(id);
	}
	
}
