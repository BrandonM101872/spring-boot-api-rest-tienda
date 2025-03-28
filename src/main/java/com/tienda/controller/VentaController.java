package com.tienda.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import com.tienda.modelo.Venta;
import com.tienda.repository.ClienteRepositorio;
import com.tienda.repository.VentaRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("ventas")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class VentaController {
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@GetMapping("listarV")
	public List<Map<String, Object>> obtenerVenta(){
		List<Object[]> ventas = ventaRepository.obtenerVentasConIdCliente();
		
		List<Map<String, Object>> resultado = new ArrayList<>();
		for (Object[] v : ventas) {
			Map<String, Object> ventasMap = new HashMap<>();
			ventasMap.put("id", v[0]);
			ventasMap.put("fecha", v[1]);
			ventasMap.put("total", v[2]);
			ventasMap.put("id_cliente", v[3]);
			resultado.add(ventasMap);
		}
		return resultado;
	}
	
	@GetMapping("/{id}")
	public Optional<Venta> getVentaById(@PathVariable int id){
		return ventaRepository.findById(id);
	}
	
	@PostMapping
	public Venta agregarVenta(@RequestBody Venta venta) {
		Optional<Cliente> ClienteOpt = clienteRepositorio.findById(venta.getCliente().getId());
		
		if (!ClienteOpt.isPresent()) {
			throw new EntityNotFoundException("Cliente con ID " + venta.getCliente().getId() + " no encontrado");
		}
		
		Cliente cliente = ClienteOpt.get();
		venta.setCliente(cliente);
		
		return ventaRepository.save(venta);
	}
	
	@PutMapping("/{id}")
	public Venta modificarProducto(@RequestBody Venta venta, @PathVariable int id) {
		venta.setId(id);
		return ventaRepository.save(venta);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarVenta(@PathVariable int id) {
		ventaRepository.deleteById(id);
	}
}
