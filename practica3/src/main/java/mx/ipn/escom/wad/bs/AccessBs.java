package mx.ipn.escom.wad.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.dao.AccessDao;
import mx.ipn.escom.wad.entidad.Access;

@Service("accessBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AccessBs {

	@Autowired
	private AccessDao accessDao;
	
	@Transactional
	public void addAccess(Access access) {
		accessDao.add(access);
	}
	
}
