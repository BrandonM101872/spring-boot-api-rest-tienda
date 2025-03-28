package com.tienda.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "TELEFONO")
	private String telefono;
	@Column(name = "CORREO")
	private String correo;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Venta> ventas;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(int id, String nombre, String telefono, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
