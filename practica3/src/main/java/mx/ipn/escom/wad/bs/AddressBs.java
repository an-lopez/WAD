package mx.ipn.escom.wad.bs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.dao.AddressDao;
import mx.ipn.escom.wad.entidad.Address;

@Service("addressBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class AddressBs {
	
	@Autowired
	private AddressDao addressDao;
	
	@Transactional
	public void addAddress(Address address) {
		addressDao.add(address);
	}
}
