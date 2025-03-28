package com.tienda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.modelo.Producto;
import com.tienda.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({"productos"})
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	//tipo de metodo GET: http://localhost:7575/productos/listar
	@GetMapping("listarP")
	public List<Producto> listaProductos() {
		List<Producto> productos = (List<Producto>) productRepository.findAll();
		return productos;
	}
	//tipo de metodo GET: http://localhost:7575/productos/{id}
	@GetMapping("/{id}")
	public Optional<Producto> getProductoById(@PathVariable int id){
		return productRepository.findById(id);
	}
	//tipo de metodo POST: http://localhost:7575/productos
	@PostMapping
	public Producto agregarProducto(@RequestBody Producto producto) {
		return productRepository.save(producto);
	}
	//tipo de metodo PUT: http://localhost:7575/productos/{id}
	@PutMapping("/{id}")
	public Producto modificarProducto(@RequestBody Producto producto, @PathVariable int id) {
		producto.setId(id);
		return productRepository.save(producto);
	}
	//tipo de metodo DELETE: http://localhost:7575/productos/{id}
	@DeleteMapping("/{id}")
	public void eliminarProducto(@PathVariable int id) {
		productRepository.deleteById(id);
	}
}
