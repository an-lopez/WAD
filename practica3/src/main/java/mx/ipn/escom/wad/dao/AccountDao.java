package mx.ipn.escom.wad.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import mx.ipn.escom.wad.entidad.Account;

@Repository("accountDao")
public class AccountDao {
	@PersistenceContext
	private EntityManager entityManagerFactory;

	public void delete(Account account) {
		entityManagerFactory.remove(account);
		entityManagerFactory.flush();
	}
	
	public void add(Account account) {
		entityManagerFactory.persist(account);
	}
}
