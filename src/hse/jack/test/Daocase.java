package hse.jack.test;

import org.junit.Before;
import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.json.JsonLoader;

public abstract class Daocase {

	protected Dao dao;
	protected Ioc ioc;

	@Before
	public void setup() {
		ioc = new NutIoc(new JsonLoader("/ioc/dao.js"));
		dao = ioc.get(Dao.class, "dao");
	}
}
