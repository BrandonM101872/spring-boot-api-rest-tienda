package com.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{
	
	@Query(value = "SELECT v.ID, v.FECHA, v.TOTAL, v.ID_CLIENTE FROM VENTA v", nativeQuery = true)
    List<Object[]> obtenerVentasConIdCliente();
}
