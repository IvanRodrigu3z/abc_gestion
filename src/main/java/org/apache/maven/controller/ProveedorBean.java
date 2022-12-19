package org.apache.maven.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.maven.dao.ProveedorDAO;
import org.apache.maven.model.Proveedor;

@ManagedBean (name="proveedorBean")
@RequestScoped
public class ProveedorBean {
	
	//lista los proveedores registrados
	public List<Proveedor> obtenerProveedores(){
		ProveedorDAO provDAO = new ProveedorDAO();
		return provDAO.listarProveedores();
	}
	
	//recibe id del proveedor y lo edita
	public String editar(int id) {
		ProveedorDAO provDAO = new ProveedorDAO();
		Proveedor prov = new Proveedor();
		prov = provDAO.buscar(id);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", prov);
		return "/faces/editar.xhtml";
	}
	
	//actualiza los datos de un proveedor
	public String actualizar(Proveedor proveedor) {
		ProveedorDAO prov = new ProveedorDAO();
		prov.editar(proveedor);
		
		return "/faces/index.xhtml";
	}
	
	//elimina proveedor
	public String eliminar(int id) {
		ProveedorDAO provDAO = new ProveedorDAO();
		provDAO.eliminar(id);
				
		return "faces/index.xhtml";
	}
	
	//redirecciona a formulario para registro
	public String registrar() {
		Proveedor prov = new Proveedor();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", prov);
		return "/faces/registrar.xhtml";
	}
	
	//guarda nuevo registro
	public String guardar(Proveedor proveedor) {
		ProveedorDAO provDAO = new ProveedorDAO();
		provDAO.guardar(proveedor);
		
		return "/faces/index.xhtml";
	}
}
