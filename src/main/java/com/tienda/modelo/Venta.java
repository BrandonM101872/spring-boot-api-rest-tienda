package com.tienda.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "VENTA")
@SequenceGenerator(name = "venta_seq", sequenceName = "venta_seq", allocationSize = 1)
public class Venta {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_seq")
	private int id;
	@Column(name = "FECHA")
	private Date fecha;
	@Column(name = "TOTAL")
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
	private Cliente cliente;
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venta(int id, Date fecha, double total, Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
