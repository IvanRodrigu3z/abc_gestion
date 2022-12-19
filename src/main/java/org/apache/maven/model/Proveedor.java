package org.apache.maven.model;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int identificacion;
	@Column
	private String direccion;
	@Column
	private String correo;
	@Column
	private int cant_vehi;
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getCant_vehi() {
		return cant_vehi;
	}
	public void setCant_vehi(int cant_vehi) {
		this.cant_vehi = cant_vehi;
	}
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", identificacion="
				+ identificacion + ", direccion=" + direccion + ", correo=" + correo + ", cant_vehi=" + cant_vehi + "]";
	}
	
	
}
