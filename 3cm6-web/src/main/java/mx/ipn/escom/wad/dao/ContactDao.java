package mx.ipn.escom.wad.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.ipn.escom.wad.entidad.Contact;

@Repository("contactDao")
public class ContactDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;

	public void delete(Contact contact) {
		entityManagerFactory.remove(contact);
		entityManagerFactory.flush();
	}
}
