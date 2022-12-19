package org.apache.maven.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.JPAUtil;
import org.apache.maven.model.Proveedor;
public class ProveedorDAO {
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//guarda nuevo registro
	public void guardar(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.persist(proveedor);
		entity.getTransaction().commit();
		
		//JPAUtil.shutdown(); //cierra conexion a BBDD
	}
	
	//edita registro
	public void editar(Proveedor proveedor) {
		entity.getTransaction().begin();
		entity.merge(proveedor);
		entity.getTransaction().commit();
		
		//JPAUtil.shutdown();
	}
	
	//busca registro
	public Proveedor buscar(int id) {
		Proveedor prov = new Proveedor();
		prov = entity.find(Proveedor.class, id); //busca en bbdd
		//JPAUtil.shutdown();
		return prov;
	}
	
	//obtiene todos los registros
	public List<Proveedor> listarProveedores(){
		List<Proveedor> listProv = new ArrayList<>();
		Query q = entity.createQuery("SELECT p FROM Proveedor p");
		listProv = q.getResultList();
		
		return listProv;
	}

	//elimina registro
	public void eliminar(int id) {
		Proveedor prov = new Proveedor();
		prov = entity.find(Proveedor.class, id);
		entity.getTransaction().begin();
		entity.remove(prov);
		entity.getTransaction().commit();
	}
}
