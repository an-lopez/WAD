package mx.ipn.escom.wad.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.ipn.escom.wad.entidad.Access;

@Repository("accessDao")
public class AccessDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;
	
	public void delete(Access access) {
		entityManagerFactory.remove(access);
		entityManagerFactory.flush();
	}
}
