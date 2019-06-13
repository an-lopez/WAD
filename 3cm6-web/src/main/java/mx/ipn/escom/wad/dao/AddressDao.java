package mx.ipn.escom.wad.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.ipn.escom.wad.entidad.Address;

@Repository("addressDao")
public class AddressDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;

	public void delete(Address address) {
		entityManagerFactory.remove(address);
		entityManagerFactory.flush();
	}
}
