package hse.jack.test;

import static org.junit.Assert.assertEquals;
import hse.jack.model.Account;

import org.junit.Test;

/**
 * <b>account单元测试</b>
 * 
 * @author jack
 * 
 */
public class AccountTestCase extends Daocase {

	@Test
	public void addAccount() {
		Account obj = new Account();
		obj.setUserName("admin");
		obj.setPassword("admin");
		obj.setStatus("0");
		dao.insert(obj);

		assertEquals("===", obj.getUserName());
	}
}
